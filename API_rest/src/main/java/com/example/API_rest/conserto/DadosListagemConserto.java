package com.example.API_rest.conserto;


public record DadosListagemConserto(String data_entrada, String data_saida, String nome, String marca, String modelo) {

    public DadosListagemConserto(Conserto conserto) {
        this(conserto.getDataEntrada(), conserto.getDataSaida(), conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}
