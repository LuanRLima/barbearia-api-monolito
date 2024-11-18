package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.Servico;
import com.manguetech.edu.barbeariaapi.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    @Autowired
    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    public ResponseEntity<Void> createServico(@RequestBody Servico servico) {
        servicoService.save(servico);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Servico>> getAllServicos() {
        List<Servico> allServicos = servicoService.getAll();
        return ResponseEntity.ok(allServicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        Servico servico = servicoService.get(id, "Servico not found");
        return ResponseEntity.ok(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable Long id,@RequestBody Servico servico) {
        Servico updatedServico = servicoService.update(id, servico);
        return ResponseEntity.ok(updatedServico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        servicoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
