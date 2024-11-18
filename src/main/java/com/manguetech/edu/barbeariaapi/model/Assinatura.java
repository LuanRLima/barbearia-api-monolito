package com.manguetech.edu.barbeariaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @FutureOrPresent
    private Date dataInicio;
    @FutureOrPresent
    private Date dataFim;
    @Pattern(regexp = "^(ativa|inativa)$")
    private String status;
}
