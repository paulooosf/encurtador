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

    @NotBlank(message = "O link deve ser preenchido!")
    private String link;

    @NotBlank(message = "O código deve ser gerado!")
    private String codigo;

    @NotNull(message = "A data deve ser gerada!")
    private LocalDateTime data;

    @NotNull(message = "O número de acessos deve ser gerado!")
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
