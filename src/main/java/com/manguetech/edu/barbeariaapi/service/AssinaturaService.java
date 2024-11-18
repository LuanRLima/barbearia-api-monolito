package com.manguetech.edu.barbeariaapi.service;

import com.manguetech.edu.barbeariaapi.model.Assinatura;

public interface AssinaturaService extends GenericService<Assinatura>{
    public Assinatura update(Long id, Assinatura assinatura);
}