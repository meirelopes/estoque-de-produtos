package com.catalisa.estoque.core.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI openAi() {

        return new OpenAPI()
                .info(new Info()
                        .title("Estoque API")
                        .version("v1")
                        .description("API para gerenciamento de estoque de produtos")
                        .license(new License()
                                .name("Apache 4.0")
                                .url("https://maven.apache.org/"))

                );
    }

}
