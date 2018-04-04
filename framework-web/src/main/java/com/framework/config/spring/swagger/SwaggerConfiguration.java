package com.framework.config.spring.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * Configuration Class for Swagger.
 *
 * @author Rohit
 * @version 1.0
 *
 */
@EnableSwagger
@Configuration
public class SwaggerConfiguration {

	/**
	 *
	 */
	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Setting spring swagger configuration.
	 *
	 * @param springSwaggerConfig
	 */
	@Autowired
	public void setSpringSwaggerConfig(final SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public SwaggerSpringMvcPlugin allAPIImplementation() {
		return new SwaggerSpringMvcPlugin(springSwaggerConfig).apiInfo(apiInfo("API Documentation"))
				.includePatterns(".*api.*");
	}

	/**
	 *
	 * @param title
	 * @return
	 */
	private ApiInfo apiInfo(final String title) {
		return new ApiInfo(title, "", "", "", "", "");

	}
}
