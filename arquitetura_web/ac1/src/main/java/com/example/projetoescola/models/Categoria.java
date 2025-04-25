package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(length = 200, nullable = false)
    private String cat_nome;

    @Column(length = 200, nullable = false)
    private String cat_descricao;

    //criando o relacionamento n produto <-> 1 categoria
    @OneToMany(mappedBy = "categoriaProduto", fetch = FetchType.EAGER)
    private List<Produto> produtos;

    //construtores

    public Categoria(Long id_categoria, String cat_nome, String cat_descricao) {
        this.id_categoria = id_categoria;
        this.cat_nome = cat_nome;
        this.cat_descricao = cat_descricao;
    }

    public Categoria() {
    }


    //get e set
    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }

    public String getCat_descricao() {
        return cat_descricao;
    }

    public void setCat_descricao(String cat_descricao) {
        this.cat_descricao = cat_descricao;
    }

    @Override
    public String toString() {
        return "Categoria [id_categoria=" + id_categoria + ", cat_nome=" + cat_nome + ", cat_descricao=" + cat_descricao
                + ", produtos=" + produtos + "]";
    }   

    
    

}
