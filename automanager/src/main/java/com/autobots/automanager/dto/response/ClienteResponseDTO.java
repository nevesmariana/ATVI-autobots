package com.autobots.automanager.dto.response;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String nomeSocial;
    private Date dataNascimento;
    private Date dataCadastro;

    private List<DocumentoResponseDTO> documentos;
    private EnderecoResponseDTO endereco;
    private List<TelefoneResponseDTO> telefones;
}