package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.Categoria;
import com.example.projetoescola.repositories.CategoriaRepository;

@RestController
@RequestMapping("/produto/categoria")

public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping()
    public List<Categoria> mostrarTodos() {
        return categoriaRepository.selecionarTodos();
    }

     @PostMapping()
    public Categoria inserir(@RequestBody Categoria categoria) {
        return categoriaRepository.inserir(categoria);
    }
}
