package com.epam.time;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = LoginController.class)
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return (regex("/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Time API")
				.description("Time API for all Crud Operation")
				.termsOfServiceUrl("http://localhost:8081")
				.contact("sanjay_raikwar@epam.com").license("EPAM License")
				.licenseUrl("sanjay_raikwar@epam.com").version("1.0").build();
	}

}
