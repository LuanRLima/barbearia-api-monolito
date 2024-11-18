package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.HistoricoServico;
import com.manguetech.edu.barbeariaapi.repository.HistoricoServicoRepository;
import com.manguetech.edu.barbeariaapi.service.HistoricoServicoService;
import org.springframework.stereotype.Service;

@Service
public class HistoricoServicoServiceImpl extends GenericServiceImpl<HistoricoServico, Long, HistoricoServicoRepository> implements HistoricoServicoService {

    public HistoricoServicoServiceImpl(HistoricoServicoRepository repository) {
        super(repository);
    }

    public HistoricoServico update(Long id, HistoricoServico historicoServico) {
        HistoricoServico historicoServicoSalvo = get(id, "HistoricoServico not found");
        return repository.save(historicoServicoSalvo);
    }
}
