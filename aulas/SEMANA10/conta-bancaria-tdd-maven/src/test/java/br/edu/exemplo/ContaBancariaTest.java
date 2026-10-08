package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaTest {

    @Test
    void deveDepositarValorNaConta() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        assertEquals(100, conta.getSaldo(), 0.001);
    }

    @Test
    void deveAcumularDepositos() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.depositar(50);
        assertEquals(150, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSacarValorDaConta() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(40);
        assertEquals(60, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueMaiorQueSaldo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(150);
        assertEquals(100, conta.getSaldo(), 0.001);
    }
}
