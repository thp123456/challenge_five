package com.challengethree.Swagger.Configuration;

import java.util.List;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.HTTP,
		scheme = "bearer",
		bearerFormat = "JWT"
)
public class SwaggerConfig {
	@Bean
	public OpenAPI openapi(@Value("${springdoc.api-docs.title}") String title,
			@Value("${springdoc.api-docs.description}") String description,
			@Value("${springdoc.api-docs.servers[0].url}") String serverUrl) {
		return new OpenAPI().info(new Info().title(title).description(description))
				.servers(List.of(new Server().url(serverUrl)));
	}

	@Bean
	public GroupedOpenApi groupOpenApi() {
		return GroupedOpenApi.builder().group("Product").packagesToScan("com.challengethree.Swagger.Controller")
				.build();
	}
}
