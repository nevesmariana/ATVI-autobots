package com.autobots.automanager.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dto.request.EnderecoRequestDTO;
import com.autobots.automanager.dto.response.EnderecoResponseDTO;
import com.autobots.automanager.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoControle {

    @Autowired
    private EnderecoService service;

    @PostMapping("/cadastro")
    public ResponseEntity<EnderecoResponseDTO> cadastrarEndereco(
            @Valid @RequestBody EnderecoRequestDTO dto) {

        EnderecoResponseDTO resposta = service.cadastrarEndereco(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resposta);
    }

    @GetMapping("/enderecos")
    public ResponseEntity<List<EnderecoResponseDTO>> obterEnderecos() {

        return ResponseEntity.ok(service.obterEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> obterEndereco(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obterEndereco(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(
            @PathVariable Long id,
            @Valid @RequestBody EnderecoRequestDTO dto) {

        return ResponseEntity.ok(
                service.atualizarEndereco(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEndereco(
            @PathVariable Long id) {

        service.excluirEndereco(id);

        return ResponseEntity.noContent().build();
    }
}