package com.manguetech.edu.barbeariaapi.repository;

import com.manguetech.edu.barbeariaapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
