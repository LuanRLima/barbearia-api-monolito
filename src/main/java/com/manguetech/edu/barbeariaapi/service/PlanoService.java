package com.manguetech.edu.barbeariaapi.service;

import com.manguetech.edu.barbeariaapi.model.Agendamento;
import com.manguetech.edu.barbeariaapi.model.Plano;

public interface PlanoService extends GenericService<Plano>{
    public Plano update(Long id, Plano plano);
}