package com.example.API_rest.mecanico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosMecanico(
        @NotBlank String nome,
        @Pattern(regexp = "\\d+", message = "Anos de experiência devem ser um valor numérico") String anos_de_experiencia
) {
}
