package com.catalisa.estoque.api.exceptionhandler;

import com.catalisa.estoque.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice // especialização da anotação @Component, que permite manipular exceções
public class ApiExceptionHandler extends ResponseEntityExceptionHandler { // classe de exceptionhandler global
    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNaoEncontradaException(
            EntidadeNaoEncontradaException ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        String detail = ex.getLocalizedMessage();
        Problem problem = Problem.builder()
                .status(status.value())
                .type("https://catalisa.com.br/entidade-nao-encontrada")
                .title("Entidade não encontrada")
                .detail(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);

    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,

                                                             HttpStatus status, WebRequest request) {

        if (body == null) {

            body = Problem.builder()
                    .title(status.getReasonPhrase()) // pequena descrição do status da resposta
                    .status(status.value())
                    .build();

        } else if (body instanceof String) {

            body = Problem.builder()
                    .title((String) body) // pequena descrição do status da resposta
                    .status(status.value())
                    .build();

        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
