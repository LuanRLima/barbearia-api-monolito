package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.Assinatura;
import com.manguetech.edu.barbeariaapi.service.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assinaturas")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    @Autowired
    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @PostMapping
    public ResponseEntity<Void> createAssinatura(@RequestBody Assinatura assinatura) {
        assinaturaService.save(assinatura);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Assinatura>> getAllAssinaturas() {
        List<Assinatura> allAssinaturas = assinaturaService.getAll();
        return ResponseEntity.ok(allAssinaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assinatura> getAssinaturaById(@PathVariable Long id) {
        Assinatura assinatura = assinaturaService.get(id, "Assinatura not found");
        return ResponseEntity.ok(assinatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assinatura> updateAssinatura(@PathVariable Long id,@RequestBody Assinatura assinatura) {
        Assinatura updatedAssinatura = assinaturaService.update(id, assinatura);
        return ResponseEntity.ok(updatedAssinatura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssinatura(@PathVariable Long id) {
        assinaturaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
