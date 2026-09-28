package com.autobots.automanager.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dto.request.ClienteRequestDTO;
import com.autobots.automanager.dto.response.ClienteResponseDTO;
import com.autobots.automanager.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {

    @Autowired
    private ClienteService service;

    @GetMapping("/cliente/{id}")
    public ClienteResponseDTO obterCliente(@PathVariable long id) {
        return service.obterCliente(id);
    }

    @GetMapping("/clientes")
    public List<ClienteResponseDTO> obterClientes() {
        return service.obterClientes();
    }

    @PostMapping("/cadastro")
    public void cadastrarCliente(
            @Valid @RequestBody ClienteRequestDTO cliente) {

        service.cadastrarCliente(cliente);
    }

    @PutMapping("/atualizar/{id}")
    public void atualizarCliente(
            @PathVariable long id,
            @Valid @RequestBody ClienteRequestDTO atualizacao) {

        service.atualizarCliente(id, atualizacao);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirCliente(@PathVariable long id) {
        service.excluirCliente(id);
    }
}