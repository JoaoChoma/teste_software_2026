package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoTest {

    @Test
    void produtoDeveIniciarComEstoqueZero() {
        Produto produto = new Produto("Teclado");

        assertEquals(0, produto.getQuantidade());
    }

    @Test
    void deveAdicionarProdutoAoEstoque() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);

        assertEquals(10, produto.getQuantidade());
    }

    @Test
    void deveAcumularQuantidadeEmEstoque() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.adicionarEstoque(5);

        assertEquals(15, produto.getQuantidade());
    }

    @Test
    void deveRetirarProdutoDoEstoque() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.retirarEstoque(3);

        assertEquals(7, produto.getQuantidade());
    }

    @Test
    void naoDeveRetirarQuantidadeMaiorQueEstoque() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.retirarEstoque(15);

        assertEquals(10, produto.getQuantidade());
    }

    @Test
    void naoDeveAdicionarQuantidadeNegativa() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(-10);

        assertEquals(0, produto.getQuantidade());
    }
}
