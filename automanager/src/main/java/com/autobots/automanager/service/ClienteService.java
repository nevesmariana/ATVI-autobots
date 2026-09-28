package com.autobots.automanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentoRepositorio;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.dto.request.ClienteRequestDTO;
import com.autobots.automanager.dto.request.DocumentoRequestDTO;
import com.autobots.automanager.dto.response.ClienteResponseDTO;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.excecoes.ClienteNaoEncontradoException;
import com.autobots.automanager.excecoes.DocumentoDuplicadoException;
import com.autobots.automanager.mapper.ClienteMapper;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio repositorio;

    @Autowired
    private ClienteMapper mapper;

    @Autowired
    private DocumentoRepositorio documentoRepositorio;

    public List<ClienteResponseDTO> obterClientes() {
        List<Cliente> clientes = repositorio.findAll();

        List<ClienteResponseDTO> dtos = new java.util.ArrayList<>();

        for (Cliente cliente : clientes) {
            dtos.add(mapper.paraResponseDTO(cliente));
        }
        return dtos;
    }

    public ClienteResponseDTO obterCliente(long id) {
        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));
        return mapper.paraResponseDTO(cliente);
    }

    public void cadastrarCliente(ClienteRequestDTO dto) {
        if (dto.getDocumentos() != null) {
            for (var documento : dto.getDocumentos()) {
                if (documentoRepositorio.existsByNumero(documento.getNumero())) {
                    throw new DocumentoDuplicadoException(documento.getNumero());
                }
            }
        }
        Cliente cliente = mapper.paraEntidade(dto);
        repositorio.save(cliente);
    }

    public void atualizarCliente(long id, ClienteRequestDTO dto) {
        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));
        
        mapper.atualizarEntidade(cliente, dto);
        repositorio.save(cliente);
    }

    public void excluirCliente(long id) {
        Cliente cliente = repositorio.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));
        repositorio.delete(cliente);
    }
}