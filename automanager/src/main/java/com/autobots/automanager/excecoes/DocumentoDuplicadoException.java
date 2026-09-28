package com.autobots.automanager.excecoes;

public class DocumentoDuplicadoException extends RuntimeException {

    public DocumentoDuplicadoException(String numero) {
        super("Já existe um documento cadastrado com o número: " + numero);
    }
}