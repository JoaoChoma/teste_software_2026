

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.choma.CalculadoraFrete;

public class CalculadoraFreteTest {

    private CalculadoraFrete calculadora;

    @BeforeEach
    void preparar() {
        calculadora = new CalculadoraFrete();
    }
    
    @Test
    public void deveCobrarFreteQuandoCompraComumEstaAbaixoDeDuzentos() {
        assertEquals(20.0, calculadora.calcular(199.99, false), 0.001);
    }
}