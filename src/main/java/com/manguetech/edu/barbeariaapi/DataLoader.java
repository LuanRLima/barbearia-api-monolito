package com.manguetech.edu.barbeariaapi;

import com.manguetech.edu.barbeariaapi.model.*;
import com.manguetech.edu.barbeariaapi.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClienteService clienteService;
    private final PlanoService planoService;
    private final AssinaturaService assinaturaService;
    private final BarbeiroService barbeiroService;
    private final ServicoService servicoService;
    private final AgendamentoService agendamentoService;
    private final PagamentoService pagamentoService;
    private final HistoricoServicoService historicoServicoService;

    public DataLoader(ClienteService clienteService,
                      PlanoService planoService,
                      AssinaturaService assinaturaService,
                      BarbeiroService barbeiroService,
                      ServicoService servicoService,
                      AgendamentoService agendamentoService,
                      PagamentoService pagamentoService,
                      HistoricoServicoService historicoServicoService) {
        this.clienteService = clienteService;
        this.planoService = planoService;
        this.assinaturaService = assinaturaService;
        this.barbeiroService = barbeiroService;
        this.servicoService = servicoService;
        this.agendamentoService = agendamentoService;
        this.pagamentoService = pagamentoService;
        this.historicoServicoService = historicoServicoService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            loadClientes("files/clientes.txt");
            loadPlanos("files/planos.txt");
            loadAssinaturas("files/assinaturas.txt");
            loadBarbeiros("files/barbeiros.txt");
            loadServicos("files/servicos.txt");
            loadAgendamentos("files/agendamentos.txt");
            loadPagamentos("files/pagamentos.txt");
            loadHistoricoServicos("files/historico_servicos.txt");
        }  catch (IOException e) {
        System.err.println("Error reading data files: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Unexpected error during data loading: " + e.getMessage());
        e.printStackTrace();
    }

    }

    private void loadClientes(String filePath) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] parts = line.split(", ");
            Cliente cliente = new Cliente();
            cliente.setNome(parts[0]);
            cliente.setEmail(parts[1]);
            cliente.setTelefone(parts[2]);
            String dataString = parts[3];
            cliente.setDataNascimento(LocalDate.parse(dataString));
            cliente.setPontosFidelidade(Integer.parseInt(parts[4]));
            clienteService.save(cliente);
        }
    }

    private void loadPlanos(String filePath) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] parts = line.split(", ");
            Plano plano = new Plano();
            plano.setNome(parts[0]);
            plano.setDescricao(parts[1]);
            plano.setValorMensal(Double.parseDouble(parts[2]));
            plano.setDescontos(Double.parseDouble(parts[3]));
            planoService.save(plano);
        }
    }

    private void loadAssinaturas(String filePath) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] parts = line.split(", ");
            Assinatura assinatura = new Assinatura();
            assinatura.setCliente(clienteService.get(Long.parseLong(parts[0]), "Cliente not found"));
            assinatura.setPlano(planoService.get(Long.parseLong(parts[1]), "Plano not found"));
            assinatura.setDataInicio(java.sql.Date.valueOf(parts[2]));
            assinatura.setDataFim(java.sql.Date.valueOf(parts[3]));
            assinatura.setStatus(parts[4]);
            assinaturaService.save(assinatura);
        }
    }

    private void loadBarbeiros(String filePath) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] parts = line.split(", ");
            Barbeiro barbeiro = new Barbeiro();
            barbeiro.setNome(parts[0]);
            barbeiro.setEspecialidades(parts[1]);
            barbeiro.setHorarioTrabalho(parts[2]);
            barbeiroService.save(barbeiro);
        }
    }

    private void loadServicos(String filePath) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] parts = line.split(", ");
            Servico servico = new Servico();
            servico.setNome(parts[0]);
            servico.setDescricao(parts[1]);
            servico.setPreco(Double.parseDouble(parts[2]));
            servico.setDuracao(Integer.parseInt(parts[3]));
            servicoService.save(servico);
        }
    }

    private void loadAgendamentos(String filePath) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] parts = line.split(", ");
            Agendamento agendamento = new Agendamento();
            agendamento.setCliente(clienteService.get(Long.parseLong(parts[0]),"Cliente not found"));
            agendamento.setBarbeiro(barbeiroService.get(Long.parseLong(parts[1]),"Barbeiro not found"));
            agendamento.setServico(servicoService.get(Long.parseLong(parts[2]),"Servico not found"));
            agendamento.setDataHora(parts[3]);
            agendamento.setDuracao(Integer.parseInt(parts[4]));
            agendamento.setStatus(parts[5]);
            agendamento.setLocal(parts[6]);
            agendamento.setPago(Boolean.parseBoolean(parts[7]));
            agendamento.setValorTotal(Double.parseDouble(parts[8]));
            agendamentoService.save(agendamento);
        }
    }

    private void loadPagamentos(String filePath) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] parts = line.split(", ");
            Pagamento pagamento = new Pagamento();
            pagamento.setAgendamento(agendamentoService.get(Long.parseLong(parts[0]),"Agendamento not found"));
            pagamento.setValor(Double.parseDouble(parts[1]));
            pagamento.setFormaPagamento(parts[2]);
            pagamento.setStatus(parts[3]);
            pagamento.setDataPagamento(parts[4].equals("null") ? null : java.sql.Date.valueOf(parts[4]));
            pagamentoService.save(pagamento);
        }
    }

    private void loadHistoricoServicos(String filePath) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] parts = line.split(", ");
            HistoricoServico historicoServico = new HistoricoServico();
            historicoServico.setCliente(clienteService.get(Long.parseLong(parts[0]),"Cliente not found"));
            historicoServico.setServico(servicoService.get(Long.parseLong(parts[1]),"Servico not found"));
            historicoServico.setData(java.sql.Date.valueOf(parts[2]));
            historicoServico.setValor(Double.parseDouble(parts[3]));
            historicoServicoService.save(historicoServico);
        }
    }
}
