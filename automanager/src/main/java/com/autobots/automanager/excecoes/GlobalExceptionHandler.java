package com.autobots.automanager.excecoes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarClienteNaoEncontrado(
            ClienteNaoEncontradoException exception) {

        Map<String, String> resposta = new HashMap<>();

        resposta.put("erro", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(resposta);
    }

    @ExceptionHandler(DocumentoDuplicadoException.class)
    public ResponseEntity<Map<String, String>> tratarDocumentoDuplicado(
            DocumentoDuplicadoException exception) {

        Map<String, String> resposta = new HashMap<>();

        resposta.put("erro", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(resposta);
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarValidacao(
            MethodArgumentNotValidException exception) {

        Map<String, String> resposta = new HashMap<>();

        exception.getBindingResult()
            .getFieldErrors()
            .forEach(erro -> resposta.put(
                    erro.getField(),
                    erro.getDefaultMessage()
            ));

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(resposta);
    }

    @ExceptionHandler(DocumentoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarDocumentoNaoEncontrado(
            DocumentoNaoEncontradoException exception) {

        Map<String, String> resposta = new HashMap<>();

        resposta.put("erro", exception.getMessage());

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(resposta);
    }

    @ExceptionHandler(EnderecoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarEnderecoNaoEncontrado(
            EnderecoNaoEncontradoException exception) {

        Map<String, String> resposta = new HashMap<>();

        resposta.put("erro", exception.getMessage());

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(resposta);
    }

    @ExceptionHandler(TelefoneNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarTelefoneNaoEncontrado(
            TelefoneNaoEncontradoException exception) {

        Map<String, String> resposta = new HashMap<>();

        resposta.put("erro", exception.getMessage());

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(resposta);
    }
}