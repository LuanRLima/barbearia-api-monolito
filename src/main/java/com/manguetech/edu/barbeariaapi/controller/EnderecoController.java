package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.Endereco;
import com.manguetech.edu.barbeariaapi.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController extends GenericController<Endereco> {

    public EnderecoController(EnderecoService service) {
        super(service);
    }

    @Autowired
    private EnderecoService enderecoService;
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Endereco endereco) {
        enderecoService.save(endereco);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<Endereco>> getAll() {
        return ResponseEntity.ok(enderecoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> get(@PathVariable Long id, String noSuchElementException) {
        return ResponseEntity.ok(enderecoService.get(id, "Endereco not found"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
