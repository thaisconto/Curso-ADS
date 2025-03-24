package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;


@Repository
public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Integer>{
    public List<CategoriaCurso> findByNome(String nome);
    public List<CategoriaCurso> findByNomeLike(String nome);

}
