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

import com.autobots.automanager.dto.request.TelefoneRequestDTO;
import com.autobots.automanager.dto.response.TelefoneResponseDTO;
import com.autobots.automanager.service.TelefoneService;

@RestController
@RequestMapping("/telefone")
public class TelefoneControle {

    @Autowired
    private TelefoneService service;

    @PostMapping("/cadastro")
    public ResponseEntity<TelefoneResponseDTO> cadastrarTelefone(
            @Valid @RequestBody TelefoneRequestDTO dto) {

        TelefoneResponseDTO resposta = service.cadastrarTelefone(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resposta);
    }

    @GetMapping("/telefones")
    public ResponseEntity<List<TelefoneResponseDTO>> obterTelefones() {

        return ResponseEntity.ok(service.obterTelefones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneResponseDTO> obterTelefone(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obterTelefone(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneResponseDTO> atualizarTelefone(
            @PathVariable Long id,
            @Valid @RequestBody TelefoneRequestDTO dto) {

        return ResponseEntity.ok(
                service.atualizarTelefone(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTelefone(
            @PathVariable Long id) {

        service.excluirTelefone(id);

        return ResponseEntity.noContent().build();
    }
}