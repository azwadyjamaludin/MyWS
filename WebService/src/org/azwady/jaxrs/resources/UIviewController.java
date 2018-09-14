package org.azwady.jaxrs.resources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/uiview")
public class UIviewController {
	
    public UIviewController() {
    	
    }
	
	@POST
	@Path("/index")
	@Produces(MediaType.TEXT_HTML)
	public void index(@Context HttpServletResponse servletResponse) throws IOException {
		servletResponse.sendRedirect("../View/index.html");
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
