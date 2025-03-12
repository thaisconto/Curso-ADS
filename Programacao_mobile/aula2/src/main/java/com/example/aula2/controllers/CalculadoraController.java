package com.example.aula2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.aula2.dtos.CalculadoraResquestDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CalculadoraController {
    @GetMapping("somar")
    public Double somar(@RequestParam("n1") Double n1,
            @RequestParam("n2") Double n2) {
        return n1 + n2;
    }

    @GetMapping("subtrair/{n1}/{n2}")
    public Double subtrair(@PathVariable("n1") Double n1,
            @PathVariable("n2") Double n2) {
        return n1 - n2;
    }

    @PostMapping("multiplicar")
    public Double multiplicar(
            @RequestBody CalculadoraResquestDTO calc) {
        return calc.getN1() * calc.getN2();
    }

    @PutMapping("dividir")
    public Double dividir(@RequestBody CalculadoraResquestDTO calc) {
        return calc.getN1() / calc.getN2();

    }

    @DeleteMapping("deletar/{id}")
    public String deletar(@PathVariable("id") Long id) {
        return "Deletando o id: " + id;
    }

}
