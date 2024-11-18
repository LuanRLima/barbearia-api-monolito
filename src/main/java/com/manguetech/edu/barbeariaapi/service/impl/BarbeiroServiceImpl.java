package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Barbeiro;
import com.manguetech.edu.barbeariaapi.repository.BarbeiroRepository;
import com.manguetech.edu.barbeariaapi.service.BarbeiroService;
import org.springframework.stereotype.Service;

@Service
public class BarbeiroServiceImpl extends GenericServiceImpl<Barbeiro, Long, BarbeiroRepository> implements BarbeiroService {

    public BarbeiroServiceImpl(BarbeiroRepository repository) {
        super(repository);
    }

    public Barbeiro update(Long id, Barbeiro barbeiro) {
        Barbeiro barbeiroSalvo = get(id, "Barbeiro not found");
        return repository.save(barbeiroSalvo);
    }
}
