package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.Agendamento;
import com.manguetech.edu.barbeariaapi.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController extends GenericController<Agendamento> {
    public AgendamentoController(AgendamentoService service) {
        super(service);
    }

    @Autowired
    private AgendamentoService agendamentoService;
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Agendamento agendamento) {
        agendamentoService.save(agendamento);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<Agendamento>> getAll() {
        return ResponseEntity.ok(agendamentoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> get(@PathVariable Long id, String noSuchElementException) {
        return ResponseEntity.ok(agendamentoService.get(id, "Agendamento not found"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> update(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        return ResponseEntity.ok(agendamentoService.update(id, agendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agendamentoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
