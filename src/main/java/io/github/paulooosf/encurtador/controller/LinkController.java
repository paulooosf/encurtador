package io.github.paulooosf.encurtador.controller;

import io.github.paulooosf.encurtador.dto.LinkDTO;
import io.github.paulooosf.encurtador.dto.LinkInfoDTO;
import io.github.paulooosf.encurtador.service.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    LinkService service;

    @GetMapping("/{codigo}")
    @Operation(summary = "Acessa um link encurtado", description = "A resposta da requisição irá direcionar até o link que foi encurtado.")
    public ResponseEntity<Void> acessar (@PathVariable String codigo) throws URISyntaxException {
        URI uri = new URI(service.acessar(codigo));
        return ResponseEntity.status(302).location(uri).build();
    }

    @GetMapping("/info/{id}")
    @Operation(summary = "Lista informações sobre um link", description = "A resposta da requisição irá mostrar informações gerais sobre o link encurtado.")
    public ResponseEntity<LinkInfoDTO> buscar (@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    @Operation(summary = "Encurta um link", description = "A requisição irá gerar um link encurtado que irá direcionar até o link original.")
    public ResponseEntity<LinkDTO> encurtar (String link) {
        return ResponseEntity.ok(service.encurtar(link));
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Edita um link encurtado", description = "A resposta da requisição irá editar o redirecionamento de um link encurtado.")
    public ResponseEntity<LinkDTO> editar (@PathVariable Long id, String link) {
        return ResponseEntity.ok(service.editar(id, link));
    }

    @DeleteMapping("/remover/{id}")
    @Operation(summary = "Remove um link encurtado", description = "A resposta da requisição irá remover um link que foi encurtado.")
    public ResponseEntity<LinkDTO> deletar (@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
