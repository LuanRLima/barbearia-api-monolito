package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.Plano;
import com.manguetech.edu.barbeariaapi.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PlanoService pagamentoService;

    @Autowired
    public PagamentoController(PlanoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<Void> createPlano(@RequestBody Plano pagamento) {
        pagamentoService.save(pagamento);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Plano>> getAllPlanos() {
        List<Plano> allPlanos = pagamentoService.getAll();
        return ResponseEntity.ok(allPlanos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Plano> getPlanoById(@PathVariable Long id) {
        Plano pagamento = pagamentoService.get(id, "Plano not found");
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> updatePlano(@PathVariable Long id,@RequestBody Plano pagamento) {
        Plano updatedPlano = pagamentoService.update(id, pagamento);
        return ResponseEntity.ok(updatedPlano);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlano(@PathVariable Long id) {
        pagamentoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
