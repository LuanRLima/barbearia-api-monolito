# Sistema de Agendamento de Serviços com Spring Boot

Este projeto é uma aplicação de **agendamento de serviços** desenvolvida com **Spring Boot**. Ele permite que os clientes agendem serviços, visualizem históricos de agendamentos, consultem seus pagamentos e mais.

## Tecnologias Utilizadas

- **Backend**:
    - Spring Boot
    - Spring Data JPA
    - H2 Database (para desenvolvimento) ou outro banco de dados de sua escolha
    - Lombok
    - Bean Validation (javax.validation)


## Funcionalidades

### 1. **Cadastro e Login de Cliente**
- Cadastro de novos clientes com nome, e-mail, telefone, etc.
- Validação de e-mail e telefone.

### 2. **Agendamento de Serviços**
- Clientes podem agendar serviços com barbeiros.
- Cada agendamento possui informações como data, hora, serviço escolhido e barbeiro.

### 3. **Histórico de Agendamentos**
- Clientes podem consultar o histórico de agendamentos passados.

### 4. **Agendamentos Atuais**
- Clientes podem visualizar os agendamentos futuros.

### 5. **Pagamento de Serviços**
- Clientes podem visualizar e realizar o pagamento de seus agendamentos.

### 6. **Assinatura de Planos**
- Clientes podem assinar planos mensais para obter serviços com desconto.

## Estrutura do Projeto

A aplicação está dividida em 4 principais módulos:

1. **Cliente**
2. **Agendamento**
3. **Serviço**
4. **Pagamento**

### Classes principais:

- **Cliente**: Representa o cliente, com informações como nome, e-mail, telefone, histórico de serviços e pontos de fidelidade.
- **Agendamento**: Representa um agendamento feito por um cliente para um serviço com um barbeiro.
- **Servico**: Representa um serviço disponível para agendamento (corte de cabelo, barbear, etc).
- **Pagamento**: Representa o pagamento de um agendamento.

## Como Rodar o Projeto

### Backend (Spring Boot)

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seuusuario/sistema-agendamento.git
   cd sistema-agendamento
   
2. **Compilar e rodar o Spring Boot: Se você estiver utilizando o Maven:**
   ```bash
    ./gradlew clean build
    ./gradlew bootRun
   ```
3. **Acesse o backend em `http://localhost:8080`**.
4. **Banco de dados: Durante o desenvolvimento, utilizamos o H2 Database. Para ambientes de produção, você pode configurar o banco de dados preferido (MySQL, PostgreSQL, etc).**

## Endpoints da API

Aqui estão os principais endpoints da API backend:

### Clientes

- **POST /api/clientes**: Cadastro de um novo cliente.
- **GET /api/clientes**: Listar todos os clientes.
- **GET /api/clientes/{id}**: Buscar cliente por ID.
- **DELETE /api/clientes/{id}**: Deletar cliente por ID.

### Agendamentos

- **POST /api/agendamentos**: Criar um novo agendamento.
- **GET /api/agendamentos**: Listar todos os agendamentos.
- **GET /api/agendamentos/{id}**: Buscar agendamento por ID.

### Pagamentos

- **POST /api/pagamentos**: Criar pagamento de agendamento.
- **GET /api/pagamentos**: Listar todos os pagamentos.
- **GET /api/pagamentos/{id}**: Buscar pagamento por ID.

### Serviços
- **POST /api/servicos**: Criar um novo serviço.
- **GET /api/servicos**: Listar todos os serviços.
- **GET /api/servicos/{id}**: Buscar serviço por ID.
- **DELETE /api/servicos/{id}**: Deletar serviço por ID.
- **PUT /api/servicos/{id}**: Atualizar serviço por ID.

## Assinaturas
- **POST /api/assinaturas**: Criar uma nova assinatura.
- **GET /api/assinaturas**: Listar todas as assinaturas.
- **GET /api/assinaturas/{id}**: Buscar assinatura por ID.
- **DELETE /api/assinaturas/{id}**: Deletar assinatura por ID.
- **PUT /api/assinaturas/{id}**: Atualizar assinatura por ID.

## Barbeiros
- **POST /api/barbeiros**: Criar um novo barbeiro.
- **GET /api/barbeiros**: Listar todos os barbeiros.
- **GET /api/barbeiros/{id}**: Buscar barbeiro por ID.
- **DELETE /api/barbeiros/{id}**: Deletar barbeiro por ID.
- **PUT /api/barbeiros/{id}**: Atualizar barbeiro por ID.

## Planos
- **POST /api/planos**: Criar um novo plano.
- **GET /api/planos**: Listar todos os planos.
- **GET /api/planos/{id}**: Buscar plano por ID.
- **DELETE /api/planos/{id}**: Deletar plano por ID.
- **PUT /api/planos/{id}**: Atualizar plano por ID.

## Clientes
- **POST /api/clientes**: Criar um novo cliente.
- **GET /api/clientes**: Listar todos os clientes.
- **GET /api/clientes/{id}**: Buscar cliente por ID.
- **DELETE /api/clientes/{id}**: Deletar cliente por ID.
- **PUT /api/clientes/{id}**: Atualizar cliente por ID

## Como Contribuir

1. Faça um **fork** deste repositório.
2. Crie uma branch para a sua feature:
   ```bash
   git checkout -b minha-feature
3. Faça um commit com suas alterações:
   ```bash
   git commit -m 'Minha nova feature'
4. Faça um push para a sua branch:
   ```bash
    git push origin minha-feature
5. Abra um **pull request**.

## Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.# barbearia-api-monolito
