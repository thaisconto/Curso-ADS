package com.example.ativ4.controllers;
import com.example.ativ4.models.Endereco;
import com.example.ativ4.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> getEnderecoById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        return new ResponseEntity<>(enderecoService.save(endereco), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        if (enderecoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        endereco.setId(id);
        return ResponseEntity.ok(enderecoService.save(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
