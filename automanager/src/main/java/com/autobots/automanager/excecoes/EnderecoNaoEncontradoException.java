package com.autobots.automanager.excecoes;

public class EnderecoNaoEncontradoException extends RuntimeException {

    public EnderecoNaoEncontradoException(Long id) {
        super("Endereço não encontrado com o id: " + id);
    }
}