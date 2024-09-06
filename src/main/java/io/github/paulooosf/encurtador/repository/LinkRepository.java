package io.github.paulooosf.encurtador.repository;

import io.github.paulooosf.encurtador.dto.LinkDTO;
import io.github.paulooosf.encurtador.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findByCodigo(String codigo);
}
