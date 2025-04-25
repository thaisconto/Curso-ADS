package com.example.ac1.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Livro> livro = new ArrayList<>();

    
     @Override
    public String toString() {
        return "Autor [id=" + id + ", nome=" + nome + ", livro=" + livro + "]";
    }

     public Autor(Long id, String nome, List<Livro> livro) {
        this.id = id;
        this.nome = nome;
        this.livro = livro;
    }

     public Autor() {
    }

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public String getNome() {
         return nome;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }

     public void adicionarLivro(Livro livro) {
        this.livro.add(livro);
        livro.setAutor(this);
    }

    public void removerLivro(Livro livro) {
        this.livro.remove(livro);
        livro.setAutor(null);
    }



    
}
