package com.manguetech.edu.barbeariaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String dataHora;
    private Integer duracao;
    @NotNull
    @Pattern(regexp = "^(agendado|confirmado|cancelado)$")
    private String status;
    @Size(max = 255)
    private String observacoes;
    @FutureOrPresent
    private Date dataHoraConfirmacao;
    @FutureOrPresent
    private Date dataHoraCancelamento;
    private String local;
    @NotNull
    private Boolean pago;
    @Positive
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    private Barbeiro barbeiro;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Pagamento> pagamentos;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
}
