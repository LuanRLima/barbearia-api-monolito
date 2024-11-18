package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Agendamento;
import com.manguetech.edu.barbeariaapi.repository.AgendamentoRepository;
import com.manguetech.edu.barbeariaapi.service.AgendamentoService;
import org.springframework.stereotype.Service;

@Service
public class AgedamentoServiceImpl extends GenericServiceImpl<Agendamento, Long, AgendamentoRepository> implements AgendamentoService {

    public AgedamentoServiceImpl(AgendamentoRepository repository) {
        super(repository);
    }

    @Override
    public Agendamento update(Long id, Agendamento agendamento) {
        get(id, "Agendamento não encontrado");
        return repository.save(agendamento);
    }
}
