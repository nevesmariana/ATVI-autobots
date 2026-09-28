package com.autobots.automanager.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EnderecoRequestDTO {

    @NotBlank
    private String estado;

    @NotBlank
    private String cidade;

    private String bairro;

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    private String codigoPostal;

    private String informacoesAdicionais;
}