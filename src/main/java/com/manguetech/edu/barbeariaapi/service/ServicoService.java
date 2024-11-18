package com.manguetech.edu.barbeariaapi.service;

import com.manguetech.edu.barbeariaapi.model.Servico;

public interface ServicoService extends GenericService<Servico>{
    public Servico update(Long id, Servico servico);
}