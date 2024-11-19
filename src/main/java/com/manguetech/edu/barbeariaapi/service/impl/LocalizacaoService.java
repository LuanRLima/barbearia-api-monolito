package com.manguetech.edu.barbeariaapi.service.impl;

import java.util.Collection;

import com.manguetech.edu.barbeariaapi.client.EnderecoClient;
import com.manguetech.edu.barbeariaapi.client.LocalidadeClient;
import com.manguetech.edu.barbeariaapi.model.Endereco;
import com.manguetech.edu.barbeariaapi.model.Estado;
import com.manguetech.edu.barbeariaapi.model.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LocalizacaoService {

    @Autowired
    private EnderecoClient enderecoClient;
    @Autowired
    private LocalidadeClient localidadeClient;

    public Endereco findByCep(String cep) {
        return enderecoClient.findByCep(cep);
    }

    public Collection<Estado> obterEstados(){
        return localidadeClient.obterEstados();
    }

    public Collection<Municipio> obterMunicipios(Integer uf){
        return localidadeClient.obterMunicipios(uf);
    }
}