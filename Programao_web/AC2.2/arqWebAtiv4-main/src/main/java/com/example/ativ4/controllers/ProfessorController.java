package com.example.ativ4.controllers;

import com.example.ativ4.models.Curso;
import com.example.ativ4.models.Professor;
import com.example.ativ4.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessores() {
        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Professor>> getProfessorById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        return new ResponseEntity<>(professorService.save(professor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        if (professorService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        professor.setId(id);
        return ResponseEntity.ok(professorService.save(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        professorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<Curso>> getProfessorCursos(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findProfessorCursosAndSchedules(id));
    }

    @GetMapping("/{id}/detalhe")
    public ResponseEntity<Optional<Professor>> getProfessorDetalhe(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findProfessorDetails(id));
    }
}
