package io.github.paulooosf.encurtador.dto;

import io.github.paulooosf.encurtador.model.Link;

import java.time.LocalDateTime;

public record LinkInfoDTO(
        Long id,
        String link,
        String codigo,
        LocalDateTime data,
        Integer acessos
) {
    public LinkInfoDTO(Link link) {
        this(link.getId(), link.getLink(), link.getCodigo(), link.getData(), link.getAcessos());
    }
}
