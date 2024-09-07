package io.github.paulooosf.encurtador.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;

    private String codigo;

    private LocalDateTime data;

    private Integer acessos;

    public Link() {
    }

    public Link(String link, String codigo, LocalDateTime data, Integer acessos) {
        this.link = link;
        this.codigo = codigo;
        this.data = data;
        this.acessos = acessos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getAcessos() {
        return acessos;
    }

    public void setAcessos(Integer acessos) {
        this.acessos = acessos;
    }
}
