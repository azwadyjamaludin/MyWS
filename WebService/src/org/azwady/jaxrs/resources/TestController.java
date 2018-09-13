package org.azwady.jaxrs.resources;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("/test")
public class TestController {
	private JSONObject jsonObject = new JSONObject();
	private File jsonFile = new File("/Users/azwady/Public/data/test-data.json");
	private String content = "";
	private JSONArray jsonArray = new JSONArray();
	
	
	public TestController() {
	}
	
	@GET
	@Path("/extraService")
	@Produces("application/json")
	public Response extraService() throws IOException {
		content = FileUtils.readFileToString(jsonFile, "utf-8");
		jsonObject = new JSONObject(content); //stream json object
		jsonArray = jsonObject.getJSONArray("extraService");
		return Response.status(200).entity(jsonArray.toString(4)).build(); //org.json pretty print - .toString(4)
	}
	
	@GET
	@Path("/createBooking")
	@Produces("application/json")
	public Response createBooking() throws IOException {
		content = FileUtils.readFileToString(jsonFile, "utf-8");
		jsonObject = new JSONObject(content);
		jsonArray = jsonObject.getJSONArray("createBooking");
		return Response.status(200).entity(jsonArray.toString(4)).build();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
