package com.example.ac2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ac2.DTO.DadosProjetoDTO;
import com.example.ac2.DTO.FuncionarioDTO;
import com.example.ac2.services.FuncionarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.adicionar(funcionarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/projetos")
    public ResponseEntity<List<DadosProjetoDTO>> buscarProjetos(@PathVariable Integer id) {
        return ResponseEntity.ok(funcionarioService.buscarProjetos(id));
    }
}