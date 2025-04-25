package com.example.ac1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac1.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    @Query
    (value = "select * from Livro where preco > :valor", nativeQuery = true)
    List<Livro> livroMaiorQueValor(@Param("valor") Double valor);

    @Query
    (value = "select * from Livro where preco < :valor or preco = :valor", nativeQuery = true)
    List<Livro> livroMenorOuIgualQueValor(@Param("valor") Double valor);

    @Query
    (value = "select * from Livro where titulo like :nome%", nativeQuery = true)
    List<Livro> livroComecandoCom(@Param("nome") String nome);
    
}
