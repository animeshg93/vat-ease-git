package com.aexp.resteasy;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.aexp.model.Image;
import com.aexp.model.Receipt;
import com.aexp.parser.ImageParser;
import com.aexp.parser.ParserResponse;
import com.aexp.parser.ParserUtil;
import com.google.protobuf.ByteString;

@Path("/growth")
public class RestService {

	@GET
	public Response printMessage() {
		return Response.status(200).entity("Hello World").build();

	}

	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ParserResponse post(Image image) throws IOException{
		ImageParser parser = new ImageParser();
		byte[] decodedImage = null;
		decodedImage = ParserUtil.decodeBase64(image.getImage());
		Receipt response = null;

		FileOutputStream imageOutFile = new FileOutputStream("C:/Users/agand22/Desktop/convert.jpg");
		imageOutFile.write(decodedImage);
		imageOutFile.close();

		ByteString string = ByteString.copyFrom(decodedImage);
		try {
			response = (Receipt) parser.parse(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;

	}

}
