package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.Agendamento;
import com.manguetech.edu.barbeariaapi.model.Plano;
import com.manguetech.edu.barbeariaapi.service.AgendamentoService;
import com.manguetech.edu.barbeariaapi.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    private final PlanoService planoService;

    @Autowired
    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @PostMapping
    public ResponseEntity<Void> createPlano(@RequestBody Plano plano) {
        planoService.save(plano);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Plano>> getAllPlanos() {
        List<Plano> allPlanos = planoService.getAll();
        return ResponseEntity.ok(allPlanos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> getPlanoById(@PathVariable Long id) {
        Plano plano = planoService.get(id, "Plano not found");
        return ResponseEntity.ok(plano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> updatePlano(@PathVariable Long id,@RequestBody Plano plano) {
        Plano updatedPlano = planoService.update(id, plano);
        return ResponseEntity.ok(updatedPlano);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlano(@PathVariable Long id) {
        planoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
