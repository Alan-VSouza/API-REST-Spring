package com.example.API_rest.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    String marca;
    String modelo;
    String ano;

    public Veiculo(DadosVeiculo dados){
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
    }
}
