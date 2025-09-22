package com.example.civa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Buses API")
                        .description("Servicio para extraer información de buses")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo Civa")
                                .email("soporte@civa.com")
                                .url("https://civa.com")));
    }

}