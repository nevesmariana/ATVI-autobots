package com.autobots.automanager.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TelefoneRequestDTO {

    @NotBlank
    private String ddd;

    @NotBlank
    private String numero;
}