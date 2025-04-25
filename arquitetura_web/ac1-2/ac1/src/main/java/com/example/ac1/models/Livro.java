package com.example.ac1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;


    @Column(length = 200, nullable = false)
    private Double preco;

    
    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", preco=" + preco + "]";
    }
    
    public Livro(String titulo, Double preco) {
        this.titulo = titulo;
        this.preco = preco;
    }

    public Livro(Long id, String titulo, Double preco) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
    }

    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    

    
    
}
