package com.manguetech.edu.barbeariaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;
    private Integer duracao;

    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos;

    @ManyToMany(mappedBy = "servicosInclusos")
    private List<Plano> planos;

    @OneToMany(mappedBy = "servico")
    private List<HistoricoServico> historicos;
}
