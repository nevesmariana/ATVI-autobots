package com.autobots.automanager.excecoes;

public class DocumentoNaoEncontradoException extends RuntimeException {

    public DocumentoNaoEncontradoException(Long id) {
        super("Documento não encontrado com o id: " + id);
    }
}