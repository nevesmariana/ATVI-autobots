package com.autobots.automanager.mapper;

import org.springframework.stereotype.Component;

import com.autobots.automanager.dto.request.TelefoneRequestDTO;
import com.autobots.automanager.dto.response.TelefoneResponseDTO;
import com.autobots.automanager.entidades.Telefone;

@Component
public class TelefoneMapper {

    public Telefone paraEntidade(TelefoneRequestDTO dto) {
        Telefone telefone = new Telefone();

        telefone.setDdd(dto.getDdd());
        telefone.setNumero(dto.getNumero());

        return telefone;
    }

    public TelefoneResponseDTO paraResponseDTO(Telefone telefone) {
        TelefoneResponseDTO dto = new TelefoneResponseDTO();

        dto.setId(telefone.getId());
        dto.setDdd(telefone.getDdd());
        dto.setNumero(telefone.getNumero());

        return dto;
    }

    public void atualizarEntidade(
            Telefone telefone,
            TelefoneRequestDTO dto) {

        telefone.setDdd(dto.getDdd());
        telefone.setNumero(dto.getNumero());
    }
}