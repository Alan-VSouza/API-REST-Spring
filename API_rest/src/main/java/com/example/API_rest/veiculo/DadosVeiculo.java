package com.example.API_rest.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank(message = "Marca não informada") String marca,
        @NotBlank(message = "Modelo não informado") String modelo,
        @NotBlank @Pattern(regexp = "\\d{4}", message = "Ano Inválido | 4 dígitos necessários.") String ano,
        String cor
) {
}
