package org.upsi.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/wvisit")
public class WVisitController {
	private JSONObject jsonObject = new JSONObject();
	
	public WVisitController() {
		
	}

	@GET
	@Path("/initiate")
	@Produces("application/json")
	public Response initiate() {
		jsonObject.put("init", "WVisitController");
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}
