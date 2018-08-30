package com.aexp.parser;

import java.io.IOException;

import org.jboss.resteasy.util.Base64;

public class ParserUtil {
	public static byte[] decodeBase64(String encodedString){
		try {
			return Base64.decode(encodedString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
