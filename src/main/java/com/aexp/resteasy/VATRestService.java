package com.aexp.resteasy;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.aexp.db.CouchbaseBucket;
import com.aexp.model.Image;
import com.aexp.model.Receipt;
import com.aexp.parser.ImageParser;
import com.aexp.parser.ParserResponse;
import com.aexp.parser.ParserUtil;
import com.aexp.vat.VATRate;
import com.aexp.vat.VATResponse;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.google.protobuf.ByteString;

@Path("/growth")
public class VATRestService {

	@GET
	public Response healthCheck() {
		return Response.status(200).entity("Hello World").build();

	}

	@Path("/getVAT")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ParserResponse post(Image image) throws Exception{
		ImageParser parser = new ImageParser();
		byte[] decodedImage = null;
		decodedImage = ParserUtil.decodeBase64(image.getImage());
		Receipt response = null;

		ByteString string = ByteString.copyFrom(decodedImage);
		try {
			response = (Receipt) parser.parse(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VATResponse rate = VATRate.getVatRate("GB");
		return response;

	}
	
	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertInCB(Receipt r) {
		CouchbaseBucket bucket = new CouchbaseBucket();
		String obj = JacksonUtil.getStringFromObject(r);
		JsonObject doc = JsonObject.fromJson(obj);
		bucket.getBucket().insert(JsonDocument.create(UUID.randomUUID().toString(), doc));
		return Response.status(200).entity("Document successfully inserted in Couchbase").build();
	}

}
