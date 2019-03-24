package org.azwady.jaxrs.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.upsi.eclipselink.mocoss.model.Dummy_GrpCoun;
import org.upsi.eclipselink.mocoss.model.Dummy_IndCoun;
import org.upsi.eclipselink.mocoss.repositories.MoCoSSQuery;

@Path("/mocoss")
public class MoCoSSController {
	private JSONObject jsonObject = new JSONObject();
	//private JSONArray jsonArray = new JSONArray();
	private MoCoSSQuery mQuery = new MoCoSSQuery();
	private List<Dummy_IndCoun> dummyIndList = new ArrayList<Dummy_IndCoun>();
	private List<Dummy_GrpCoun> dummyGrpList = new ArrayList<Dummy_GrpCoun>();
	
	public MoCoSSController() {
		
	}
	
	@GET
	@Path("/initiate")
	@Produces("application/json")
	public Response initiate() {
		jsonObject.put("init", "MoCoSSController");
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
	@GET
	@Path("/dummyData")
	@Produces("application/json")
	public Response dummyData() {
		
		dummyIndList = mQuery.dummyIndList();
		jsonObject.put("dummyInd", dummyIndList);
		
		dummyGrpList = mQuery.dummyGrpList();
		jsonObject.put("dummyGrp", dummyGrpList);
			
		return Response.status(200).entity(jsonObject.toString(4)).build();
	}
	

}
