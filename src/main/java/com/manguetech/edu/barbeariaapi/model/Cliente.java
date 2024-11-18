package com.manguetech.edu.barbeariaapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Cliente extends Pessoa {

    @NotNull
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "cliente")
    private List<HistoricoServico> historicoServicos;

    private Integer pontosFidelidade;

    @OneToMany(mappedBy = "cliente")
    private List<Assinatura> assinaturas;

    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos;

    @OneToOne (mappedBy = "cliente")
    private Endereco endereco;
}