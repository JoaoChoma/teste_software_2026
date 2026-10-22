package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstoqueServiceTest {
    @Test
    void deveInformarQuandoExisteEstoque() {
        EstoqueService estoque = new EstoqueService(10);
        assertTrue(estoque.temEstoque(3));
    }

    @Test
    void deveRetirarQuantidadeDoEstoque() {
        EstoqueService estoque = new EstoqueService(10);
        estoque.retirar(3);
        assertEquals(7, estoque.getQuantidade());
    }
}