package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;


@Repository
public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Integer>{
    public List<CategoriaCurso> findByNome(String nome);
    public List<CategoriaCurso> findByNomeLike(String nome);

    @Query("select cc from CategoriaCurso cc left join fetch cc.cursos c where cc.id = :id ")
    CategoriaCurso findCategoriaCursoFetchCursos(@Param("id") Long id);
    

}
