package com.d_d.kpsafetywebsite.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("kp-safety")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI kpSafetyWebsiteOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("KP Safety Website API")
                        .description("API documentation for the KP Safety website")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("KP Safety Support Department")
                                .email("kpsafetyy@gmail.com")));
    }
}
