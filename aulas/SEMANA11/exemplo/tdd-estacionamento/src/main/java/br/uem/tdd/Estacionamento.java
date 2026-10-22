package br.uem.tdd;

public class Estacionamento {
    private final int capacidadeMaxima;
    private int ocupacao;

    public Estacionamento(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void adicionarVeiculo() {
        if (ocupacao >= capacidadeMaxima) {
            throw new IllegalStateException("Estacionamento lotado");
        }
        ocupacao++;
    }
}
