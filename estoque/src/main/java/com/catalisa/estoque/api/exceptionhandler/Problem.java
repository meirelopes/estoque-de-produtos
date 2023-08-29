package com.catalisa.estoque.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder // padrão de projetos para construir objetos
@JsonInclude(JsonInclude.Include.NON_NULL) // incluir nas propriedades somente os valores que não estiverem nulos
public class Problem {

    private Integer status;
    private String type;
    private String title;
    private String detail;

}
