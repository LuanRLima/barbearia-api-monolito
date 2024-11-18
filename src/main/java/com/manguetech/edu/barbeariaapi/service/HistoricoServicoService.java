package com.manguetech.edu.barbeariaapi.service;

import com.manguetech.edu.barbeariaapi.model.HistoricoServico;

public interface HistoricoServicoService extends GenericService<HistoricoServico>{
    public HistoricoServico update(Long id, HistoricoServico historicoServico);
}