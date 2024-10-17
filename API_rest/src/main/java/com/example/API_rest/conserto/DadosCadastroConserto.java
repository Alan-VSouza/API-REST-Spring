package com.example.API_rest.conserto;

import com.example.API_rest.mecanico.DadosMecanico;
import com.example.API_rest.veiculo.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(
        @NotBlank @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}",message = "Data inválida | Ex: dd/mm/yyyy") String data_entrada,
        @NotBlank @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}",message = "Data inválida | Ex: dd/mm/yyyy") String data_saida,
        @NotNull @Valid DadosMecanico mecanico,
        @NotNull @Valid DadosVeiculo veiculo
) {
}
