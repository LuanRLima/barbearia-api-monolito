package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.Barbeiro;
import com.manguetech.edu.barbeariaapi.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbeiros")
public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    @Autowired
    public BarbeiroController(BarbeiroService barbeiroService) {
        this.barbeiroService = barbeiroService;
    }

    @PostMapping
    public ResponseEntity<Void> createBarbeiro(@RequestBody Barbeiro barbeiro) {
        barbeiroService.save(barbeiro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Barbeiro>> getAllBarbeiros() {
        List<Barbeiro> allBarbeiros = barbeiroService.getAll();
        return ResponseEntity.ok(allBarbeiros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbeiro> getBarbeiroById(@PathVariable Long id) {
        Barbeiro barbeiro = barbeiroService.get(id, "Barbeiro not found");
        return ResponseEntity.ok(barbeiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barbeiro> updateBarbeiro(@PathVariable Long id,@RequestBody Barbeiro barbeiro) {
        Barbeiro updatedBarbeiro = barbeiroService.update(id, barbeiro);
        return ResponseEntity.ok(updatedBarbeiro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarbeiro(@PathVariable Long id) {
        barbeiroService.delete(id);
        return ResponseEntity.ok().build();
    }
}
