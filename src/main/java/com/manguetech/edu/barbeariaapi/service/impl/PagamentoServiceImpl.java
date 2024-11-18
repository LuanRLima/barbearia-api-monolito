package com.manguetech.edu.barbeariaapi.service.impl;

import com.manguetech.edu.barbeariaapi.model.Pagamento;
import com.manguetech.edu.barbeariaapi.repository.PagamentoRepository;
import com.manguetech.edu.barbeariaapi.service.PagamentoService;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl extends GenericServiceImpl<Pagamento, Long, PagamentoRepository> implements PagamentoService {

    public PagamentoServiceImpl(PagamentoRepository repository) {
        super(repository);
    }
}
