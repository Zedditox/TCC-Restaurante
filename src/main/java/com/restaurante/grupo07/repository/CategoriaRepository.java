package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public List<Categoria> findByDisponivelTrue();
    public List<Categoria> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
