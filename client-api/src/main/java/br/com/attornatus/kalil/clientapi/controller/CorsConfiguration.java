package br.com.attornatus.kalil.clientapi.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

	public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedOrigins("*") 
        .allowedMethods("GET","POST","PUT", "DELETE");
        
        registry.addMapping("/indicados/**")
        .allowedOrigins("*") 
        .allowedMethods("GET","POST","PUT", "DELETE");
	}

}