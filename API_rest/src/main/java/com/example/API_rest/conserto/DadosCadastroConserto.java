package com.example.API_rest.conserto;

import com.example.API_rest.mecanico.DadosMecanico;
import com.example.API_rest.veiculo.DadosVeiculo;

public record DadosCadastroConserto(String data_entrada, String data_saida, DadosMecanico mecanico, DadosVeiculo veiculo) {
}
