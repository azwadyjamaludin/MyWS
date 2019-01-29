package org.azwady.jaxrs.resources;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.upsi.eclipselink.mocoss.repositories.MoCoSSQuery;

@Path("/mocoss")
public class MoCoSSController {
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	private MoCoSSQuery mQuery = new MoCoSSQuery();
	
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
	public Response dummyData() throws SQLException {
		JSONObject jsonObjectInd = new JSONObject();
		JSONArray jsonArrayInd = new JSONArray();
		
		JSONObject jsonObjectGrp = new JSONObject();
		JSONArray jsonArrayGrp = new JSONArray();
		
		ResultSet setInd = mQuery.dummyIndCoun();
			while (setInd.next()) {
				jsonObjectInd.put("sessionDate", setInd.getDate("session_date"));
				jsonObjectInd.put("session num", setInd.getInt("session_num"));
				jsonObjectInd.put("session code", setInd.getString("client_code"));
				jsonObjectInd.put("session start", setInd.getTime("session_hour_start"));
				jsonObjectInd.put("session end", setInd.getTime("session_hour_end"));
				jsonArrayInd.put(jsonObjectInd);
			}
			jsonObject.put("dummyInd", jsonArrayInd);
			
		ResultSet setGrp = mQuery.dummyGrpCoun();
			while (setGrp.next()) {
				jsonObjectGrp.put("session date", setGrp.getDate("session_date"));
				jsonObjectGrp.put("session num", setGrp.getInt("session_num"));
				jsonObjectGrp.put("session code", setGrp.getString("client_group_code"));
				jsonObjectGrp.put("session start", setGrp.getTime("session_hour_start"));
				jsonObjectGrp.put("session end", setGrp.getTime("session_hour_end"));
				jsonArrayGrp.put(jsonObjectGrp);
			}
			jsonObject.put("dummyGrp", jsonArrayGrp);
			
		return Response.status(200).entity(jsonObject.toString(4)).build();
	}
	

}
