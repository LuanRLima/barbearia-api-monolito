package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Endereco;
import com.manguetech.edu.barbeariaapi.repository.EnderecoRepository;
import com.manguetech.edu.barbeariaapi.service.EnderecoService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl extends GenericServiceImpl<Endereco, Long, EnderecoRepository> implements EnderecoService {

    public EnderecoServiceImpl(EnderecoRepository repository) {
        super(repository);
    }
    public Endereco insert(Long id, Endereco cliente) {
        Endereco clienteSalvo = get(id, "Endereco not found");
        return repository.save(cliente);
    }
}
