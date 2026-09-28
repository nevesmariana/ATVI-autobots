package com.autobots.automanager.excecoes;

public class TelefoneNaoEncontradoException extends RuntimeException {

    public TelefoneNaoEncontradoException(Long id) {
        super("Telefone não encontrado com o id: " + id);
    }
}