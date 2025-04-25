package com.example.projetoescola.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Curso;


@Repository
// o tipo da variável dentro do JpaRepository deve ser a mesma que do id da entidade
public interface CursoRepository extends JpaRepository <Curso, Long>{
   //select * from curso where nome = ?
    public List<Curso> findByNome(String nome);
    //select * from curso where nome like ?
    public List<Curso> findByNomeLike(String nome);


}




        


