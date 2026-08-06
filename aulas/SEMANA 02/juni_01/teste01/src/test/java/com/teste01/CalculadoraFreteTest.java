package com.teste01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraFreteTest {

    private CalculadoraFrete calculadora;

    @BeforeEach
    void preparar() {
        calculadora = new CalculadoraFrete();
    }

    @Test
    @DisplayName("Compra comum abaixo do limite paga frete")
    void deveCobrarFreteQuandoCompraComumEstaAbaixoDeDuzentos() {
        assertEquals(20.0, calculadora.calcular(199.99, false), 0.001);
    }

    @Test
    @DisplayName("Compra comum no limite recebe frete gratis")
    void deveIsentarFreteQuandoCompraComumAtingeDuzentos() {
        assertEquals(0.0, calculadora.calcular(200.0, false), 0.001);
    }

    @Test
    @DisplayName("Valor negativo e rejeitado")
    void deveRejeitarValorDeCompraNegativo() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(-0.01, false));

        assertEquals("valorCompra não pode ser negativo", erro.getMessage());
    }

    @ParameterizedTest(name = "valor={0}, premium={1} => frete={2}")
    @CsvSource({
            "199.99, false, 20.0",
            "200.00, false,  0.0",
            "200.01, false,  0.0",
            " 99.99, true,  20.0",
            "100.00, true,   0.0",
            "100.01, true,   0.0"
    })
    @DisplayName("Frete respeita os limites de cada perfil")
    void deveCalcularFreteNosLimites(double valor, boolean premium, double esperado) {
        assertEquals(esperado, calculadora.calcular(valor, premium), 0.001);
    }
}
