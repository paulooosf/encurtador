package io.github.paulooosf.encurtador.service;

import io.github.paulooosf.encurtador.dto.LinkDTO;
import io.github.paulooosf.encurtador.dto.LinkInfoDTO;
import io.github.paulooosf.encurtador.exception.NotFoundException;
import io.github.paulooosf.encurtador.model.Link;
import io.github.paulooosf.encurtador.repository.LinkRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;

    public String acessar (String codigo) {
        Optional<Link> linkOpt = repository.findByCodigo(codigo);
        if (linkOpt.isEmpty()) {
            throw new NotFoundException();
        }
        Link link = linkOpt.get();
        link.setAcessos(link.getAcessos() + 1);
        repository.save(link);

        return link.getLink();
    }

    public LinkInfoDTO buscar (Long id) {
        Optional<Link> linkOpt = repository.findById(id);
        if (linkOpt.isEmpty()) {
            throw new NotFoundException();
        }
        return new LinkInfoDTO(linkOpt.get());
    }

    public LinkDTO encurtar (String linkOriginal) {
        Link link = new Link(linkOriginal, GeradorCodigos.gerarCodigoAleatorio(), LocalDateTime.now(), 0);
        repository.save(link);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("link/")
                .path(link.getCodigo())
                .buildAndExpand()
                .toUri();
        return new LinkDTO(uri.toString());
    }

    public LinkDTO editar (Long id, String linkEditado) {
        Optional<Link> linkOpt = repository.findById(id);
        if (linkOpt.isEmpty()) {
            throw new NotFoundException();
        }
        Link link = linkOpt.get();
        link.setLink(linkEditado);
        repository.save(link);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("link/")
                .path(link.getCodigo())
                .buildAndExpand()
                .toUri();
        return new LinkDTO(uri.toString());
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException();
        }
        repository.deleteById(id);
    }
}
