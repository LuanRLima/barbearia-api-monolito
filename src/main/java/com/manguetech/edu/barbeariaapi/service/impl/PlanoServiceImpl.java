package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Plano;
import com.manguetech.edu.barbeariaapi.repository.PlanoRepository;
import com.manguetech.edu.barbeariaapi.service.PlanoService;
import org.springframework.stereotype.Service;

@Service
public class PlanoServiceImpl extends GenericServiceImpl<Plano, Long, PlanoRepository> implements PlanoService {

    public PlanoServiceImpl(PlanoRepository repository) {
        super(repository);
    }

    @Override
    public Plano update(Long id, Plano plano) {
        get(id, "Plano não encontrado");
        return repository.save(plano);
    }
}
