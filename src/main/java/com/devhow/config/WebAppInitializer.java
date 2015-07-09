package com.devhow.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * This class replaces the web.xml config. The application context is coming
 * from AppConfig and dispatcher-servlet is set with WebMvcConfig
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext rootAppConfigContext = new AnnotationConfigWebApplicationContext();
		rootAppConfigContext.register(RootConfigurations.class);

		servletContext.addListener(new ContextLoaderListener(rootAppConfigContext));
		//creation of dispatcher servlet
		AnnotationConfigWebApplicationContext configDispatcherContext = new AnnotationConfigWebApplicationContext();
		configDispatcherContext.register(WebMvcConfig.class);

		ServletRegistration.Dynamic dispatcherServlet = servletContext
				.addServlet("dispatcher", new DispatcherServlet(configDispatcherContext));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/");

	}

}
