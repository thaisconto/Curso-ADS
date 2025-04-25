package com.example.ac2.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{
    
    @Query
    ("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
    Optional<Projeto> projetoEFuncionarioPorIdProjeto(@Param("id") Integer id);

    @Query
    ("SELECT p FROM Projeto p WHERE p.dataInicio BETWEEN :dataInicio AND :dataFim")
    List<Projeto> projetoEntreDatas(@Param("dataInicio") LocalDate dataInicio,
                                @Param("dataFim") LocalDate dataFim);
}
