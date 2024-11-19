package com.manguetech.edu.barbeariaapi.client;


import com.manguetech.edu.barbeariaapi.model.Estado;
import com.manguetech.edu.barbeariaapi.model.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "ibge")
public interface LocalidadeClient {

    @GetMapping(value = "/estados")
    Collection<Estado> obterEstados();

    @GetMapping(value = "/estados/{uf}/municipios")
    Collection<Municipio> obterMunicipios(@PathVariable Integer uf);
}