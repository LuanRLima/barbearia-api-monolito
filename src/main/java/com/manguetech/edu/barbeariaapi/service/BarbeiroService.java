package com.manguetech.edu.barbeariaapi.service;

import com.manguetech.edu.barbeariaapi.model.Barbeiro;

public interface BarbeiroService extends GenericService<Barbeiro>{
    public Barbeiro update(Long id, Barbeiro barbeiro);
}