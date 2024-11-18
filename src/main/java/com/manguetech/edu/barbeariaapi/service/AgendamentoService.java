package com.manguetech.edu.barbeariaapi.service;

import com.manguetech.edu.barbeariaapi.model.Agendamento;

public interface AgendamentoService extends GenericService<Agendamento>{
    public Agendamento update(Long id, Agendamento agendamento);
}