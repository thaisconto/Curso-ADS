package com.example.projetoescola.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

     @Column(length = 200, nullable = false)
    private String produto_nome;

    @Column(nullable = false)
    private Integer produto_qntd;

    //criando o relacionamento n produto <-> 1 categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoriaProduto;

    //construtor
    public Produto() {
    }

    public Produto(Long id_produto, String produto_nome, Integer produto_qntd) {
        this.id_produto = id_produto;
        this.produto_nome = produto_nome;
        this.produto_qntd = produto_qntd;
    }

    // get e set
    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    public Integer getProduto_qntd() {
        return produto_qntd;
    }

    public void setProduto_qntd(Integer produto_qntd) {
        this.produto_qntd = produto_qntd;
    }

    @Override
    public String toString() {
        return "Produto [id_produto=" + id_produto + ", produto_nome=" + produto_nome + ", produto_qntd=" + produto_qntd
                + ", categoriaProduto=" + categoriaProduto + "]";
    }

    


}
