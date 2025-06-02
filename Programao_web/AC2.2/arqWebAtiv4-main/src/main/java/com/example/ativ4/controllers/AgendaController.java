package com.example.ativ4.controllers;
import com.example.ativ4.config.exceptions.AgendaNaoDisponivelException;
import com.example.ativ4.config.exceptions.EspecialidadeIncompativelException;
import com.example.ativ4.models.Agenda;
import com.example.ativ4.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Agenda>> getAgendaById(@PathVariable Long id) {
        return ResponseEntity.ok(agendaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAgenda(@RequestParam Long professorId,
                                             @RequestParam Long cursoId,
                                             @RequestParam LocalDateTime inicio,
                                             @RequestParam LocalDateTime fim) {
        try {
            Agenda agenda = agendaService.cadastrarAgenda(professorId, cursoId, inicio, fim);
            return new ResponseEntity<>(agenda, HttpStatus.CREATED);
        } catch (EspecialidadeIncompativelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (AgendaNaoDisponivelException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Agenda>> getProfessorAgenda(@PathVariable Long professorId) {
        return ResponseEntity.ok(agendaService.getProfessorAgenda(professorId));
    }

    @PostMapping("/{id}/observacao")
    public ResponseEntity<?> cadastrarObservacao(@PathVariable Long id, @RequestParam String observacao) {
        try {
            Agenda agenda = agendaService.cadastrarObservacao(id, observacao);
            return ResponseEntity.ok(agenda);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Área logada para professores
    @GetMapping("/professor/meu/agenda")
    public ResponseEntity<List<Agenda>> getMinhaAgenda(@RequestParam Long professorId) { // Assuming you have a way to identify the logged-in professor
        return ResponseEntity.ok(agendaService.getProfessorAgendaAndCursos(professorId));
    }
}
