package com.aexp.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/growth")
public class RestService {

	@GET
	public Response printMessage() {
		return Response.status(200).entity("Hello World").build();

	}

	@Path("/insert")
	@POST
	public Response post(String s){
		System.out.println(s);
		return Response.status(200).entity("New image inserted").build();
 
	}

}
