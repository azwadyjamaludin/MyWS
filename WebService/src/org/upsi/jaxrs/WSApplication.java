package org.upsi.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.upsi.jaxrs.resources.MoCoSSController;
import org.upsi.jaxrs.resources.WVisitController;

@ApplicationPath("/resources")
public class WSApplication extends Application   {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rsrc = new HashSet<Class<?>>();
		rsrc.add(MoCoSSController.class);
		rsrc.add(WVisitController.class);
		return rsrc;
	}
	
		 
}
