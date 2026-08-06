package com.choma;

public final class CalculadoraFrete {

    public double calcular(double valorCompra, boolean clientePremium) {
        if (valorCompra < 0) {
            throw new IllegalArgumentException("valorCompra não pode ser negativo");
        }

        if (valorCompra >= 200.0 || (clientePremium && valorCompra >= 100.0)) {
            return 0.0;
        }

        return 20.0;
    }
}
