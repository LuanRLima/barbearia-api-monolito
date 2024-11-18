package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Servico;
import com.manguetech.edu.barbeariaapi.repository.ServicoRepository;
import com.manguetech.edu.barbeariaapi.service.ServicoService;
import org.springframework.stereotype.Service;

@Service
public class ServicoServiceImpl extends GenericServiceImpl<Servico, Long, ServicoRepository> implements ServicoService {

    public ServicoServiceImpl(ServicoRepository repository) {
        super(repository);
    }

    public Servico update(Long id, Servico servico) {
        get(id, "Servico not found");
        return repository.save(servico);
    }
}
