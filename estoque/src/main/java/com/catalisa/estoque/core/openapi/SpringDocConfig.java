package com.catalisa.estoque.core.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
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
                                .url("https://maven.apache.org/")));

    }


    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> {
            openApi.getPaths()
                    .values()
                    .forEach(pathItem -> pathItem.readOperationsMap()
                            .forEach((httpMethod, operation) -> {
                                ApiResponses responses = operation.getResponses();
                                switch (httpMethod) {
                                    case GET:
                                    case DELETE:
                                        responses.addApiResponse("404", new ApiResponse().description("Recurso não encontrado"));
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                    case POST:
                                        responses.addApiResponse("400", new ApiResponse().description("Requisição inválida"));
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                    case PUT:
                                        responses.addApiResponse("404", new ApiResponse().description("Recurso não encontrado"));
                                        responses.addApiResponse("400", new ApiResponse().description("Requisição inválida"));
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                    default:
                                        responses.addApiResponse("500", new ApiResponse().description("Erro interno no servidor"));
                                        break;
                                }
                            })
                    );
        };
    }

}