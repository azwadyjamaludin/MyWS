package org.azwady.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.azwady.jaxrs.resources.MoCoSSController;
import org.azwady.jaxrs.resources.PadimimController;
import org.azwady.jaxrs.resources.TestController;
import org.azwady.jaxrs.resources.UIviewController;
import org.azwady.jaxrs.resources.WVisitController;

@ApplicationPath("/resources")
public class WSApplication extends Application   {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rsrc = new HashSet<Class<?>>();
		rsrc.add(MoCoSSController.class);
		rsrc.add(WVisitController.class);
		rsrc.add(PadimimController.class);
		rsrc.add(UIviewController.class);
		rsrc.add(TestController.class);
		return rsrc;
	}
	
		 
}
