package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cursos/categoriaCurso")  //endereco pra api
public class CategoriaCursoController {
    
    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;

    @GetMapping()
    public List<CategoriaCurso> getTodosCategoriaCursos() {
        return categoriaCursoRepository.findAll();
    }

    @PostMapping()
    public CategoriaCurso postCategoriaCurso(@RequestBody CategoriaCurso categoriaCurso) {
        return categoriaCursoRepository.save(categoriaCurso);
    }

    /*
    @GetMapping("/{nome}")
    public List<CategoriaCurso> getCategoriaCurso() {
        return categoriaCursoRepository.obterPorNome("nome");
    }

    @DeleteMapping("/{id}")
    public void excluirCategoriaCurso(@PathVariable long id) {
        categoriaCursoRepository.excluir(id);


    }
  */  


}