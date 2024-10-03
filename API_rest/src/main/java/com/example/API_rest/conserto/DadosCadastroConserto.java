package com.example.API_rest.conserto;

import com.example.API_rest.mecanico.DadosMecanico;
import com.example.API_rest.veiculo.DadosVeiculo;

public record DadosCadastroConserto(String dataEntrada, String dataSaida, DadosMecanico mecanico, DadosVeiculo veiculo) {
}
