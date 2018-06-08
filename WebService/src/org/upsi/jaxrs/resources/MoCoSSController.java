package org.upsi.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/mocoss")
public class MoCoSSController {
	private JSONObject jsonObject = new JSONObject(); 
	
	public MoCoSSController() {
		
	}
	
	@GET
	@Path("/initiate")
	@Produces("application/json")
	public Response initiate() {
		jsonObject.put("init", "MoCoSSController");
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	

}
