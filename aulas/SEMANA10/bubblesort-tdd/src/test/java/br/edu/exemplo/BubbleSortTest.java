package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    @Test
    void deveOrdenarVetorDesordenado() {
        BubbleSort bubbleSort =
                new BubbleSort(new int[]{5, 3, 1, 4, 2});

        bubbleSort.ordenar();

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                bubbleSort.getNumeros()
        );
    }

    @Test
    void deveManterVetorJaOrdenado() {
        BubbleSort bubbleSort =
                new BubbleSort(new int[]{1, 2, 3, 4, 5});

        bubbleSort.ordenar();

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                bubbleSort.getNumeros()
        );
    }

    @Test
    void deveOrdenarVetorComValoresRepetidos() {
        BubbleSort bubbleSort =
                new BubbleSort(new int[]{3, 1, 3, 2, 1});

        bubbleSort.ordenar();

        assertArrayEquals(
                new int[]{1, 1, 2, 3, 3},
                bubbleSort.getNumeros()
        );
    }
}
