package com.manguetech.edu.barbeariaapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Getter @Setter
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private String formaPagamento;
    private String status;
    private Date dataPagamento;

    @ManyToOne
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;
}
