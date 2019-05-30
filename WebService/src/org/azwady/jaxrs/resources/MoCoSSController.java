package org.azwady.jaxrs.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.upsi.eclipselink.mocoss.model.DummyConsdet;
import org.upsi.eclipselink.mocoss.model.DummyGrp;
import org.upsi.eclipselink.mocoss.model.DummyInd;
import org.upsi.eclipselink.mocoss.model.DummyPsytest;
import org.upsi.eclipselink.mocoss.model.DummyRefdet;
import org.upsi.eclipselink.mocoss.repositories.MoCoSSQuery;

@Path("/mocoss")
public class MoCoSSController {
	private JSONObject jsonObject = new JSONObject();
	private MoCoSSQuery mQuery = new MoCoSSQuery();
	private List<DummyInd> dummyIndList = new ArrayList<DummyInd>();
	private List<DummyGrp> dummyGrpList = new ArrayList<DummyGrp>();
	private List<DummyPsytest> dummyPTList = new ArrayList<DummyPsytest>();
	private List<DummyRefdet> dummyRDList = new ArrayList<DummyRefdet>();
	private List<DummyConsdet> dummyCDList = new ArrayList<DummyConsdet>();
 	
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
		
		dummyPTList = mQuery.dummyPTList();
		jsonObject.put("dummyPsyTest",dummyPTList);
		
		dummyRDList = mQuery.dummyRDList();
		jsonObject.put("dummyRefer",dummyRDList);
		
		dummyCDList = mQuery.dummyCDList();
		jsonObject.put("dummyConsult",dummyCDList);
			
		return Response.status(200).entity(jsonObject.toString(4)).build();
	}
	

}
