package com.telemetryx.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI telemetryXOpenAPI()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("TelemetryX API")
                        .description("REST API for vehicle telemetry monitoring, hazard detection, and fleet analytics.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Manoj M T")
                        ));
    }
}