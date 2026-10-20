package br.uem.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstacionamentoTest {
    @Test
    void deveIniciarComZeroVeiculos() {
        Estacionamento estacionamento = new Estacionamento(10);
        assertEquals(0, estacionamento.getOcupacao());
    }

    @Test
    void deveArmazenarCapacidadeMaxima() {
        Estacionamento estacionamento = new Estacionamento(10);
        assertEquals(10, estacionamento.getCapacidadeMaxima());
    }

    @Test
    void deveArmazenarOutraCapacidadeMaxima() {
        Estacionamento estacionamento = new Estacionamento(25);
        assertEquals(25, estacionamento.getCapacidadeMaxima());
    }

    @Test
    void deveAdicionarUmVeiculo() {
        Estacionamento estacionamento = new Estacionamento(10);
        estacionamento.adicionarVeiculo();
        assertEquals(1, estacionamento.getOcupacao());
    }

    @Test
    void deveAcumularEntradas() {
        Estacionamento estacionamento = new Estacionamento(10);
        estacionamento.adicionarVeiculo();
        estacionamento.adicionarVeiculo();
        assertEquals(2, estacionamento.getOcupacao());
    }

    @Test
    void naoDevePermitirEntradaQuandoLotado() {
        Estacionamento estacionamento = new Estacionamento(3);
        estacionamento.adicionarVeiculo();
        estacionamento.adicionarVeiculo();
        estacionamento.adicionarVeiculo();
        assertThrows(IllegalStateException.class, estacionamento::adicionarVeiculo);
        assertEquals(3, estacionamento.getOcupacao());
    }
}
