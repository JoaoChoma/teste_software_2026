package br.edu.cesu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void deveSomarDoisNumeros() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.somar(2, 3);

        assertEquals(5, resultado);
    }

    @Test
    void deveSubtrairDoisNumeros() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.subtrair(10, 4);

        assertEquals(6, resultado);
    }

    @Test
    void deveMultiplicarDoisNumeros() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.multiplicar(3, 4);

        assertEquals(12, resultado);
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {

        Calculadora calculadora = new Calculadora();

        assertThrows(
            IllegalArgumentException.class,
            () -> calculadora.dividir(10, 0)
        );
    }
}