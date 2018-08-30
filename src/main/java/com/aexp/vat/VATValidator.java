package com.aexp.vat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.aexp.resteasy.JacksonUtil;

public class VATValidator {
    private static final String USER_AGENT = "Mozilla/5.0";

    public static VATResponse getVatResponse(String vatNumber) throws Exception {

        Map<String, String> parameters = new HashMap<>();
        String queryString= "?vat_number=" + vatNumber ;


        URL url = new URL("https://api.vatsense.com/1.0/validate" + queryString);
        //Can use this also
        //http://apilayer.net/api/validate?access_key=5f3346b2e5abdad6e9c9ea4fd35f2249&vat_number=GB986366462&format=1
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        // Include the HTTP Basic Authentication payload
        con.addRequestProperty("Authorization", "Basic " + getBasicAuthenticationEncoding());

        // Read response from web server, which will trigger HTTP Basic Authentication request to be sent.
        BufferedReader httpResponseReader =
                new BufferedReader(new InputStreamReader(con.getInputStream()));

        String lineRead;
        StringBuffer bfr = new StringBuffer();
        while((lineRead = httpResponseReader.readLine()) != null) {
            bfr.append(lineRead);
        }

        System.out.println(bfr.toString());
        return JacksonUtil.getObjectFromString(bfr.toString());

    }

    public static void main(String[] args) throws Exception {
        VATResponse response = getVatResponse("GB986366462");
        System.out.println(response.getData().getCompany().getCompany_address());
    }

    private static String getBasicAuthenticationEncoding() {

        String userPassword = "user:adeda14cc1828c5f2de661cfb800985d";
        return new String(Base64.getEncoder().encode(userPassword.getBytes()));
    }
}
