package fr.afcepf.atod26.ws.rest.web.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.afcepf.atod26.ws.rest.web.service.DeviseRestWSImpl;

@ApplicationPath("/services/rest")
public class DeviseRestApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> lesClasses = new HashSet<>();
		lesClasses.add(DeviseRestWSImpl.class);
		return lesClasses;
	}

}
