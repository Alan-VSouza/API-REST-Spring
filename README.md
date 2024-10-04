# API REST de Consertos de Veículos

Este projeto é uma API REST desenvolvida em **Spring Boot**, com persistência de dados utilizando o banco de dados **H2** e migrações gerenciadas pelo **Flyway**. A API permite o cadastro de veículos, mecânicos e consertos, com funcionalidades para adicionar e consultar registros.

## Alunos
- **Alan Andrade Vasconi de Souza** - SC3038319
- **Felipe Santos Lourenço** - SC303867X

## Funcionalidades
- **Cadastro de Consertos**: Permite cadastrar um conserto com informações sobre o veículo, mecânico, data de entrada e saída.
- **Consulta de Consertos**: Permite consultar consertos cadastrados.
- **Migrações com Flyway**: O esquema do banco de dados é gerenciado e versionado utilizando Flyway.
- **Banco de Dados H2**: Banco de dados em memória utilizado para testes e desenvolvimento.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.3.4**
- **Maven**
- **H2 Database**
- **Flyway**
- **Lombok**

## Estrutura de Classes
- **Conserto**: Representa o conserto de um veículo, com data de entrada, data de saída, mecânico responsável e veículo.
- **Mecanico**: Classe embutida (embedded) dentro de `Conserto`, representando o mecânico responsável pelo conserto.
- **Veiculo**: Classe embutida (embedded) dentro de `Conserto`, representando o veículo que está sendo consertado.

## Pré-requisitos
- **Maven** instalado e configurado no `PATH`.
- **Java 21** instalado.