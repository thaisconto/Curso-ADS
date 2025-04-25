package com.example.ac2.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;

@Builder
@Entity
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(length = 200, nullable = false)
    private String nome;

    //criando o relacionamento 1 setor  <->  n funcionarios
    @OneToMany(mappedBy = "setor")
    private List<Funcionario> funcionarios;


    //construtor, toString, getters e setters


    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Setor [id=" + id + ", nome=" + nome + ", cursos=" + funcionarios + "]";
    }

    public Setor(Integer id, String nome, List<Funcionario> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public Setor() {
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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setCursos(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

  
    
    
}
