package com.example.demo.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


	private static final Contact DEFAULT_CONTACT = new Contact("Gerald Wegner", "", "gerald.wegner@softshore.net");

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {

		String version = "Spring first attempt";

		ApiInfo apiInfo = new ApiInfo("Domains and Links ", "API Documentation", version, "urn:tos",

				DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

		return new Docket(DocumentationType.SWAGGER_2)

				.apiInfo(apiInfo)

				.produces(DEFAULT_PRODUCES_AND_CONSUMES)

				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);

	}

}