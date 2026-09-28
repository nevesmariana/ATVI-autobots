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

import com.autobots.automanager.dto.request.DocumentoRequestDTO;
import com.autobots.automanager.dto.response.DocumentoResponseDTO;
import com.autobots.automanager.service.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {

    @Autowired
    private DocumentoService service;

    @PostMapping("/cadastro")
    public ResponseEntity<DocumentoResponseDTO> cadastrarDocumento(
            @Valid @RequestBody DocumentoRequestDTO dto) {

        DocumentoResponseDTO resposta = service.cadastrarDocumento(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resposta);
    }

    @GetMapping("/documentos")
    public ResponseEntity<List<DocumentoResponseDTO>> obterDocumentos() {

        return ResponseEntity.ok(service.obterDocumentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoResponseDTO> obterDocumento(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obterDocumento(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoResponseDTO> atualizarDocumento(
            @PathVariable Long id,
            @Valid @RequestBody DocumentoRequestDTO dto) {

        return ResponseEntity.ok(
                service.atualizarDocumento(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDocumento(
            @PathVariable Long id) {

        service.excluirDocumento(id);

        return ResponseEntity.noContent().build();
    }
}