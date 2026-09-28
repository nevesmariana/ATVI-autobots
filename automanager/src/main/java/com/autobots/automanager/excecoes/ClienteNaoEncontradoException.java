package com.autobots.automanager.excecoes;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(Long id) {
        super("Cliente não encontrado com o id: " + id);
    }
}