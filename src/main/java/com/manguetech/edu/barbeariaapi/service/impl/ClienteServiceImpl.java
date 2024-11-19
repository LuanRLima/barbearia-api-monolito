package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Cliente;
import com.manguetech.edu.barbeariaapi.model.Endereco;
import com.manguetech.edu.barbeariaapi.repository.ClienteRepository;
import com.manguetech.edu.barbeariaapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long, ClienteRepository> implements ClienteService {
    @Autowired
    private LocalizacaoService localizacaoService;
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository repository) {
        super(repository);
    }

    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteSalvo = get(id, "Cliente not found");
        return repository.save(cliente);
    }

    public Cliente insert(Cliente cliente) {

        String cep = cliente.getEndereco().getCep();

        Endereco endereco = localizacaoService.findByCep(cep);

        cliente.setEndereco(endereco);

        return clienteRepository.save(cliente);
    }
}