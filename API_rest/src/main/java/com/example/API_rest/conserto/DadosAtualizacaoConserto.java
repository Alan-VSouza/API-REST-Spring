package com.example.API_rest.conserto;

import com.example.API_rest.mecanico.DadosMecanico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,
        String data_saida,
        DadosMecanico mecanico) {}
