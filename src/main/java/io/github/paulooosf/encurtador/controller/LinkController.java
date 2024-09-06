package io.github.paulooosf.encurtador.controller;

import io.github.paulooosf.encurtador.dto.LinkDTO;
import io.github.paulooosf.encurtador.dto.LinkInfoDTO;
import io.github.paulooosf.encurtador.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    LinkService service;

    @GetMapping("/{codigo}")
    public ResponseEntity<LinkDTO> acessar (@PathVariable String codigo) {
        return ResponseEntity.ok(service.acessar(codigo));
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<LinkInfoDTO> buscar (@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<LinkDTO> encurtar (String link) {
        return ResponseEntity.ok(service.encurtar(link));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<LinkDTO> editar (@PathVariable Long id, String link) {
        return ResponseEntity.ok(service.editar(id, link));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<LinkDTO> deletar (@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
