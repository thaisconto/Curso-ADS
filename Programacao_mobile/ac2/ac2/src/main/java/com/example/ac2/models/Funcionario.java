package com.example.ac2.models;

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
import lombok.Builder;

@Builder
@Entity
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(length = 200, nullable = false)
    private String nome;


    //criando o relacionamento n funcionario <-> 1 setor
    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    //criando o relacionamento n funcionario <-> n projeto
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="funcionario_projeto",
    joinColumns={@JoinColumn(name="funcionario_id")},
    inverseJoinColumns={@JoinColumn(name="projeto_id")})
    private List<Projeto> projetos;

    
    //construtor, toString, getters e setters

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", setor=" + setor + ", projetos=" + projetos + "]";
    }

    public Funcionario(Integer id, String nome, Setor setor, List<Projeto> projetos) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.projetos = projetos;
    }

    public Funcionario() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    

    
}
