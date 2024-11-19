package com.manguetech.edu.barbeariaapi.service;

import com.manguetech.edu.barbeariaapi.model.Cliente;

public interface ClienteService extends GenericService<Cliente>{
    public Cliente update(Long id, Cliente cliente);
}