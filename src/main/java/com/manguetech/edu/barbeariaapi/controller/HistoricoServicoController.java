package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.HistoricoServico;
import com.manguetech.edu.barbeariaapi.service.HistoricoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historicoservicos")
public class HistoricoServicoController {

    private final HistoricoServicoService historicoservicoService;

    @Autowired
    public HistoricoServicoController(HistoricoServicoService historicoservicoService) {
        this.historicoservicoService = historicoservicoService;
    }

    @PostMapping
    public ResponseEntity<Void> createHistoricoServico(@RequestBody HistoricoServico historicoservico) {
        historicoservicoService.save(historicoservico);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<HistoricoServico>> getAllHistoricoServicos() {
        List<HistoricoServico> allHistoricoServicos = historicoservicoService.getAll();
        return ResponseEntity.ok(allHistoricoServicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoServico> getHistoricoServicoById(@PathVariable Long id) {
        HistoricoServico historicoservico = historicoservicoService.get(id, "HistoricoServico not found");
        return ResponseEntity.ok(historicoservico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoServico> updateHistoricoServico(@PathVariable Long id,@RequestBody HistoricoServico historicoservico) {
        HistoricoServico updatedHistoricoServico = historicoservicoService.update(id, historicoservico);
        return ResponseEntity.ok(updatedHistoricoServico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoricoServico(@PathVariable Long id) {
        historicoservicoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
