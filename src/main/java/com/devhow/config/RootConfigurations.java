package com.devhow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static com.devhow.constants.ConfigConstants.PACKAGE_MODEL;
import com.devhow.service.TouristService;
import com.devhow.service.TouristServiceImpl;

@Configuration
@ComponentScan(basePackages ={PACKAGE_MODEL})
@Import(JPAConfigurations.class)
public class RootConfigurations {
	

	@Bean
	public TouristService touristService(){
		return new TouristServiceImpl();
	}
	
}
