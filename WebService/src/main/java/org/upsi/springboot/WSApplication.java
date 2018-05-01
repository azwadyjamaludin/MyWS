package org.upsi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class WSApplication extends SpringBootServletInitializer implements WebApplicationInitializer  {
	
    
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WSApplication.class);
	}
	
	public static void main(String[] args) {
        SpringApplication.run(WSApplication.class, args);
    }
		 
}
