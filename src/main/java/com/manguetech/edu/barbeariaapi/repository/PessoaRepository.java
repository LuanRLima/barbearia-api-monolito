package com.manguetech.edu.barbeariaapi.repository;

import com.manguetech.edu.barbeariaapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
