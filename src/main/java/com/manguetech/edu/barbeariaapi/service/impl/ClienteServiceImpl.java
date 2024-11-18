package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Cliente;
import com.manguetech.edu.barbeariaapi.repository.ClienteRepository;
import com.manguetech.edu.barbeariaapi.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long, ClienteRepository> implements ClienteService {

    public ClienteServiceImpl(ClienteRepository repository) {
        super(repository);
    }
}
