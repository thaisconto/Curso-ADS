package com.example.ac2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.ac2.DTO.DadosSetorDTO;
import com.example.ac2.DTO.SetorDTO;
import com.example.ac2.services.SetorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/setores")
@RequiredArgsConstructor
public class SetorController {
    private final SetorService setorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SetorDTO criar(@RequestBody SetorDTO setorDTO) {
        return setorService.criar(setorDTO);
    }

    @GetMapping
    public List<SetorDTO> listarTodos() {
        return setorService.listarTodos();
    }

    @GetMapping("/{id}")
    public DadosSetorDTO buscarPorId(@PathVariable Integer id) {
        return setorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        setorService.excluir(id);
    }

    @PutMapping("/{id}")
    public SetorDTO atualizar(@PathVariable Integer id, @RequestBody SetorDTO setorDTO) {
        return setorService.atualizar(id, setorDTO);
    }
}