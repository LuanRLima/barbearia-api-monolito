package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Pessoa;
import com.manguetech.edu.barbeariaapi.repository.PessoaRepository;
import com.manguetech.edu.barbeariaapi.service.PessoaService;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl extends GenericServiceImpl<Pessoa, Long, PessoaRepository> implements PessoaService {

    public PessoaServiceImpl(PessoaRepository repository) {
        super(repository);
    }
}
