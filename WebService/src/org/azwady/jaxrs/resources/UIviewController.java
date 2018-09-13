package org.azwady.jaxrs.resources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/uiview")
public class UIviewController {
	@Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;
	
    public UIviewController() {
    	
    }
	
	@GET
	@Path("/index")
	@Produces("text/html")
	public Response index() {
		try {
			request.getRequestDispatcher("/View/index.html").forward(request, response);
		}catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(request).build();
	}
	
	@GET
	@Path("/setting")
	@Produces("text/html")
	public Response setting() {
		try {
			request.getRequestDispatcher("/View/setting.html").forward(request, response);
		}catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(request).build();
	}
}
