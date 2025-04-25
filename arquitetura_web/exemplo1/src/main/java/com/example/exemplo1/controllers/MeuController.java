package com.example.exemplo1.controllers;

import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MeuController {
    @GetMapping("/ola")
    public String getOlaMundo(@RequestParam("n") String nome,
            @RequestParam("t") String tipo) {
        return "Olá, " + tipo + " " + nome + "!";
    }

    @GetMapping("/cliente/{id}")
    public String getCliente(@PathVariable("id") int id) {
        return "Cliente - id: " + id;
    }

}
