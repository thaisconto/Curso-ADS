package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.dto.CursoDTO;
import com.example.projetoescola.dto.CursoRequestDTO;
import com.example.projetoescola.dto.DadosCursoDTO;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.services.CursoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping()
    public List<CursoDTO> getTodosCursos() {
        return cursoService.obterTodos();
    }

    @GetMapping("{id}")
    public DadosCursoDTO obterPorId(@PathVariable Long id) {
        return cursoService.obterPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cursoService.remover(id);
    }

    @PutMapping("{id}")
    public void edit(@PathVariable Long id,
            @RequestBody CursoRequestDTO dto) {
        cursoService.editar(id, dto);
    }

    @PostMapping()
    public CursoDTO postCurso(@Valid @RequestBody CursoRequestDTO curso) {
        return cursoService.salvar(curso);
    }
}
