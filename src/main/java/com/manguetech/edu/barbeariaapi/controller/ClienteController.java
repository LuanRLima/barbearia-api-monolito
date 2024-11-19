package com.manguetech.edu.barbeariaapi.controller;

import com.manguetech.edu.barbeariaapi.model.Cliente;
import com.manguetech.edu.barbeariaapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clientes")
public class ClienteController extends GenericController<Cliente> {
    public ClienteController(ClienteService service) {
        super(service);
    }

    @Autowired
    private ClienteService clienteService;
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Long id, String noSuchElementException) {
        return ResponseEntity.ok(clienteService.get(id, "Cliente not found"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
