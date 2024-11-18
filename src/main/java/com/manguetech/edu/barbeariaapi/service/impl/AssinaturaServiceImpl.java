package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Assinatura;
import com.manguetech.edu.barbeariaapi.repository.AssinaturaRepository;
import com.manguetech.edu.barbeariaapi.service.AssinaturaService;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaServiceImpl extends GenericServiceImpl<Assinatura, Long, AssinaturaRepository> implements AssinaturaService {
    public Assinatura update(Long id, Assinatura assinatura) {
        get(id, "Assinatura not found");
        return repository.save(assinatura);
    }
    public AssinaturaServiceImpl(AssinaturaRepository repository) {
        super(repository);
    }
}
