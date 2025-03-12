package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(length = 200, nullable = false)
    private String nome;
   
    @Column(nullable = false)
    private Integer cargaHoraria;

    //criando o relacionamento n curso <-> 1 categoriaCurso
    @ManyToOne
    @JoinColumn(name = "categoriaCurso_id")
    private CategoriaCurso categoriaCurso;

   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="curso_pessoa",
    joinColumns={@JoinColumn(name="curso_id")},
    inverseJoinColumns={@JoinColumn(name="pessoa_id")})
    private List<Pessoa> pessoas;

    public void addPessoa(Pessoa p) {
        pessoas.add(p);
    }
    
    public List<Pessoa> getPessoa() {
        return pessoas;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoas = pessoa;
    }

    public Curso(Long id, String nome, Integer cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso() {
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
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
    return "Curso [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + 
           ", pessoas=" + (pessoas != null ? pessoas.stream().map(Pessoa::getNome).toList() : "[]") + "]";
    }


    public CategoriaCurso getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(CategoriaCurso categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }


}

