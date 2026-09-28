package com.autobots.automanager.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DocumentoRequestDTO {

    @NotBlank
    private String tipo;

    @NotBlank
    private String numero;
}