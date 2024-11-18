-- Inserir dados para o cliente
INSERT INTO cliente (nome, email, telefone, data_nascimento, pontos_fidelidade)
VALUES
    ('João Silva', 'joao@email.com', '123456789', '1990-01-01', 100),
    ('Maria Oliveira', 'maria@email.com', '987654321', '1985-05-12', 150);

-- Inserir dados para o plano
INSERT INTO plano (nome, descricao, valor_mensal, descontos)
VALUES
    ('Plano Bronze', 'Plano básico com descontos simples', 100.0, 10.0),
    ('Plano Prata', 'Plano intermediário com mais benefícios', 150.0, 20.0);

-- Inserir dados para assinatura
INSERT INTO assinatura (cliente_id, plano_id, data_inicio, data_fim, status)
VALUES
    (1, 1, '2024-01-01', '2025-01-01', 'Ativo'),
    (2, 2, '2024-02-01', '2025-02-01', 'Ativo');

-- Inserir dados para barbeiro
INSERT INTO barbeiro (nome, especialidades, horario_trabalho)
VALUES
    ('Carlos Souza', 'Corte Masculino, Barba', '08:00-18:00'),
    ('Fernanda Lima', 'Corte Feminino, Penteado', '09:00-17:00');

-- Inserir dados para serviço
INSERT INTO servico (nome, descricao, preco, duracao)
VALUES
    ('Corte de Cabelo', 'Corte de cabelo masculino', 30.0, 30),
    ('Corte e Barba', 'Corte de cabelo e barba', 50.0, 60);

-- Inserir dados para agendamento
INSERT INTO agendamento (cliente_id, barbeiro_id, servico_id, data_hora, duracao, status, local, pago, valor_total)
VALUES
    (1, 1, 1, '2024-11-20 10:00:00', 30, 'Confirmado', 'Barbearia Manguetech', true, 30.0),
    (2, 2, 2, '2024-11-22 14:00:00', 60, 'Confirmado', 'Barbearia Manguetech', false, 50.0);

-- Inserir dados para pagamento
INSERT INTO pagamento (agendamento_id, valor, forma_pagamento, status, data_pagamento)
VALUES
    (1, 30.0, 'Cartão de Crédito', 'Pago', '2024-11-20'),
    (2, 50.0, 'Dinheiro', 'Pendente', null);
