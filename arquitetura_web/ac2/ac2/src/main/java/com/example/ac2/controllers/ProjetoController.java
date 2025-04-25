package com.example.ac2.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ac2.DTO.DadosProjetoDTO;
import com.example.ac2.DTO.ProjetoDTO;
import com.example.ac2.services.ProjetoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {
    private final ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody ProjetoDTO projetoDTO) {
        projetoService.adicionar(projetoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosProjetoDTO> buscarProjetoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(projetoService.buscarProjetoPorId(id));
    }

    @PostMapping("/{idProjeto}/funcionarios/{idFuncionario}")
    public ResponseEntity<Void> vincularFuncionario(
            @PathVariable Integer idProjeto,
            @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<DadosProjetoDTO>> buscarProjetosEntreDatas(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim) {
        return ResponseEntity.ok(projetoService.buscarProjetosEntreDatas(inicio, fim));
    }
}