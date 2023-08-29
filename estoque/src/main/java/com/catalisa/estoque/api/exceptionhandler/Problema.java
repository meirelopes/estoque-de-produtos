package com.catalisa.estoque.api.exceptionhandler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Builder // padrão de projetos para construir objetos
public class Problema {

    private LocalDateTime dataHora;
    private String mensagem;

}
