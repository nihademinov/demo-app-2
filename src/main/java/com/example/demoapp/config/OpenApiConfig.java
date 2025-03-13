package com.example.demoapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .addServersItem(new Server().url("http://localhost:8080").description("Local environment"))
                .info(new Info().title("Demo API").version("V0.1")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org/v2/")));
    }
}
