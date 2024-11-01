package com.example.API_rest.mecanico;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    @Column(name = "mecanico_nome")
    private String nome;

    @Column(name = "mecanico_anos_de_experiencia")
    private String anosDeExperiencia;

    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.anosDeExperiencia = dados.anos_de_experiencia();
    }

    public void atualizarInformacoes(DadosMecanico dados){
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.anos_de_experiencia() != null) this.anosDeExperiencia = dados.anos_de_experiencia();
    }
}