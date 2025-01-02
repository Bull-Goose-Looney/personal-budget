package com.zach.budget.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
		registry.addMapping("/api/**") // Match the API endpoint you're exposing
				.allowedOrigins("http://localhost:3000") // React app origin
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				.allowedHeaders("*")
				.allowCredentials(true); // If you need cookies or authentication headers
	}
}
