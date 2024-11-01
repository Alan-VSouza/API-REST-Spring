package com.example.API_rest.conserto;

import com.example.API_rest.mecanico.Mecanico;

public record DadosDetalhamentoConserto(Long id, String data_saida, Mecanico mecanico) {

    public DadosDetalhamentoConserto(Conserto conserto){
        this(conserto.getId(), conserto.getDataSaida(), conserto.getMecanico());
    }
}
