package com.autobots.automanager.dto.request;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ClienteRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String nomeSocial;

    @NotNull
    private Date dataNascimento;

    @NotNull
    private Date dataCadastro;

    @Valid
    private List<DocumentoRequestDTO> documentos;

    @Valid
    private EnderecoRequestDTO endereco;

    @Valid
    private List<TelefoneRequestDTO> telefones;
}