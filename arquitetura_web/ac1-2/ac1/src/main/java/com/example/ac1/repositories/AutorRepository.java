package com.example.ac1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac1.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    @Query
    (value = "select * from Autor where nome like :nome%", nativeQuery = true)
    List<Autor> autorComecandoCom(@Param("nome") String nome);

    @Query
    (value = "select a from Autor a LEFT JOIN FETCH a.livro where a.id = :id")
    Autor autorComLivroPorIdAutor(@Param("id") Long id);
    
}
