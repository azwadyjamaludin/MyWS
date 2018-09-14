package org.azwady.jaxrs.resources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/uiview")
public class UIviewController {
	
    public UIviewController() {
    	
    }
	
	@POST
	@Path("/index")
	public void index(@Context HttpServletRequest servletRequest,
					  @Context HttpServletResponse servletResponse) {
		try {
            servletRequest.getRequestDispatcher("/View/index.html").forward(servletRequest, servletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@GET
	@Path("/setting")
	public void setting(@Context HttpServletRequest servletRequest,
						@Context HttpServletResponse servletResponse) {
		
		try {
            servletRequest.getRequestDispatcher("/View/setting.html").forward(servletRequest, servletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
