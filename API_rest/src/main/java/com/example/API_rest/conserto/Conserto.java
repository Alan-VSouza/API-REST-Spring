package com.example.API_rest.conserto;

import com.example.API_rest.mecanico.Mecanico;
import com.example.API_rest.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_entrada")
    private String dataEntrada;

    @Column(name = "data_saida")
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.ativo = true;
        this.dataEntrada = dados.data_entrada();
        this.dataSaida = dados.data_saida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if (dados.data_saida() != null) this.dataSaida = dados.data_saida();
        if (dados.mecanico() != null) this.mecanico.atualizarInformacoes(dados.mecanico());
    }

    public void excluir() {
        this.ativo = false;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
}