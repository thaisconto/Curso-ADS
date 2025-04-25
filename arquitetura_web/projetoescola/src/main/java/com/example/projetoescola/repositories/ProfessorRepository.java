package com.example.projetoescola.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.projetoescola.models.Professor;


@Repository
// o tipo da variável dentro do JpaRepository deve ser a mesma que do id da entidade
public interface ProfessorRepository extends JpaRepository <Professor, Long>{
   
    //consulta salario maior que x
    @Query
    (value = "select * from Professor where salario > :valor ", nativeQuery = true)
    List<Professor> salarioMaiorQueValor(@Param("valor") Double valor);

    //consulta salario <= x
    @Query
    (value = "select * from Professor where salario < :valor or salario = :valor", nativeQuery = true)
    List<Professor> salarioMenorIgualQueValor(@Param("valor") Double valor);

    //consulta nome que começa com x
    @Query
    (value = "select * from Professor where nome like :titulo%", nativeQuery = true)
    List<Professor> tituloComecandoCom(@Param("titulo") String titulo);


}




        


