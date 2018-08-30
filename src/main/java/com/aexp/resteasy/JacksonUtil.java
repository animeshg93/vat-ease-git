package com.aexp.resteasy;

import com.aexp.model.Receipt;
import com.aexp.vat.VATResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
    private static ObjectMapper mapper = new ObjectMapper();
    public static VATResponse getObjectFromString(String str) throws Exception{
        return  mapper.readValue(str,VATResponse.class);
    }
    
    public static String getStringFromObject(Receipt receipt){
    	try {
			return mapper.writeValueAsString(receipt);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
}
