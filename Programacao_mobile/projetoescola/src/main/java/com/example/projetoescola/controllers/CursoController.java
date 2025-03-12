package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CursoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cursos")  //endereco pra api
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public List<Curso> getTodosCursos() {
        return cursoRepository.obterTodos();
    }

    @PostMapping()
    public Curso postCurso(@RequestBody Curso curso) {
        return cursoRepository.salvar(curso);
    }

    @GetMapping("/{nome}")
    public List<Curso> getCurso() {
        return cursoRepository.obterPorNome("nome");
    }

    @DeleteMapping("/{id}")
    public void excluirCurso(@PathVariable long id) {
       cursoRepository.excluir(id);
    }
    

}
