package com.lms.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class AppConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl("http://localhost:9090");
		devServer.setDescription("Development Server");

		Server prodServer = new Server();
		prodServer.setUrl("http://localhost:9090/swagger-ui/index.html");
		prodServer.setDescription("Production Swagger UI");

		// Configure the contact info
		Contact contact = new Contact();
		contact.setEmail("info@lms.com");
		contact.setName("Library Management System");
		contact.setUrl("https://www.lms.com");

		// Configure the license
		License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

		// Set up the API information
		Info info = new Info().title("Library Management System API").version("1.0").contact(contact)
				.description("This API provides access to Library Management functionalities.")
				.termsOfService("https://www.lms.com/terms").license(mitLicense);

		// Return the OpenAPI object
		return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	}

}
