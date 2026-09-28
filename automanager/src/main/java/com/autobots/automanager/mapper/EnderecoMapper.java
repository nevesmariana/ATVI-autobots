package com.autobots.automanager.mapper;

import org.springframework.stereotype.Component;

import com.autobots.automanager.dto.request.EnderecoRequestDTO;
import com.autobots.automanager.dto.response.EnderecoResponseDTO;
import com.autobots.automanager.entidades.Endereco;

@Component
public class EnderecoMapper {

    public Endereco paraEntidade(EnderecoRequestDTO dto) {

        Endereco endereco = new Endereco();

        endereco.setEstado(dto.getEstado());
        endereco.setCidade(dto.getCidade());
        endereco.setBairro(dto.getBairro());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setCodigoPostal(dto.getCodigoPostal());
        endereco.setInformacoesAdicionais(dto.getInformacoesAdicionais());

        return endereco;
    }

    public EnderecoResponseDTO paraResponseDTO(Endereco endereco) {

        EnderecoResponseDTO dto = new EnderecoResponseDTO();

        dto.setId(endereco.getId());
        dto.setEstado(endereco.getEstado());
        dto.setCidade(endereco.getCidade());
        dto.setBairro(endereco.getBairro());
        dto.setRua(endereco.getRua());
        dto.setNumero(endereco.getNumero());
        dto.setCodigoPostal(endereco.getCodigoPostal());
        dto.setInformacoesAdicionais(endereco.getInformacoesAdicionais());

        return dto;
    }

    public void atualizarEntidade(
            Endereco endereco,
            EnderecoRequestDTO dto) {

        endereco.setEstado(dto.getEstado());
        endereco.setCidade(dto.getCidade());
        endereco.setBairro(dto.getBairro());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setCodigoPostal(dto.getCodigoPostal());
        endereco.setInformacoesAdicionais(dto.getInformacoesAdicionais());
    }
}