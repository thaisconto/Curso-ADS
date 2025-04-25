package com.example.ac2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
    
    @Query("SELECT f FROM Funcionario f LEFT JOIN FETCH f.projetos WHERE f.id = :id")
    Optional<Funcionario> projetoEFuncionarioPorIdFuncionario(@Param("id") Integer id);
    
}
