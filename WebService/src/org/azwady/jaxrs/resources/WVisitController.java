package org.azwady.jaxrs.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.upsi.eclipselink.wvisit.model.WebsiteVisit;
import org.upsi.eclipselink.wvisit.repositories.WebsiteVisitQuery;

@Path("/wvisit")
public class WVisitController {
	private JSONObject jsonObject = new JSONObject();
	private JSONObject jsonRoot = new JSONObject();
	private WebsiteVisitQuery wvQuery = new WebsiteVisitQuery();
	private List<WebsiteVisit> wvList = new ArrayList<WebsiteVisit>();
	
	public WVisitController() {
	}

	@GET
	@Path("/initiate")
	@Produces("application/json")
	public Response initiate() {
		jsonObject.put("init", "WVisitController");
		return Response.status(200).entity(jsonObject.toString(4)).build();
	}
	
	@GET
	@Path("/getlist")
	@Produces("application/json")
	public Response getList() throws JSONException, SQLException {
		 wvList = wvQuery.getList();
		jsonRoot.put("getlist", wvList); //put list into json
		return Response.status(200).entity(jsonRoot.toString(4)).build();
	}
	
	@GET
	@Path("/getlistbytotalvisit")
	@Produces("application/json")
	public Response getListByTotalVisit() throws SQLException {
		wvList = wvQuery.getListByTotalVisit();
		jsonRoot.put("getlistbytotalvisit", wvList);
		return Response.status(200).entity(jsonRoot.toString(4)).build();
	}
	
	@GET
	@Path("/getlistbydate")
	@Produces("application/json")
	public Response getListByDate(@QueryParam("selectedDate")String selectedDate) throws SQLException {
		wvList = wvQuery.getListByDate(selectedDate);
		jsonRoot.put("getlistbydate", wvList);
		return Response.status(200).entity(jsonRoot.toString()).build();
	}
	
	/*private String FormatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		return strDate;
	}*/ //Date format will be done at Front End system (iOS,Android OS)
}
