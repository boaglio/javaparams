package com.javaparams.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI javaParamsAPI() {

        return new OpenAPI()
                .info(new Info().title("JavaParams API")
                        .description("Java Parameters API - by Fernando Boaglio - YouTube @DevMultitask ")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub")
                        .url("https://github.com/boaglio/javaparams")
                );

    }

}