package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "pessoas")
    private List<Curso> cursos;

    
    public Pessoa() {
    }

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + "]";
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


    public List<Curso> getCursos() {
        return cursos;
    }


    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    

    
}
