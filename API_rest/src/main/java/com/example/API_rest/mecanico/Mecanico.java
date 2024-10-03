package com.example.API_rest.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    String nome;
    String anoDeExperiencia;

    public Mecanico(DadosMecanico dados){
        this.nome = dados.nome();
        this.anoDeExperiencia = dados.anosDeExperiencia();
    }
}
