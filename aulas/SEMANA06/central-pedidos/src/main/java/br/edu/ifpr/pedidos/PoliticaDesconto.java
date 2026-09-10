package br.edu.ifpr.pedidos;

import java.util.Locale;

public class PoliticaDesconto {
    public long calcular(Cliente cliente, long subtotal, String cupom) {
        if (subtotal < 0) throw new IllegalArgumentException("Subtotal negativo");
        long desconto;
        if (cliente.vip()) {
            desconto = subtotal * 10 / 100;
        } else if (subtotal >= 50_000) {
            desconto = subtotal * 5 / 100;
        } else {
            desconto = 0;
        }
        if (cupom == null || cupom.isBlank()) return desconto;
        switch (cupom.trim().toUpperCase(Locale.ROOT)) {
            case "BEMVINDO":
                if (cliente.comprasAnteriores() == 0 && subtotal >= 10_000) desconto += 2_000;
                break;
            case "EXTRA10":
                if (subtotal >= 20_000) desconto += subtotal * 10 / 100;
                break;
            default:
                throw new IllegalArgumentException("Cupom desconhecido");
        }
        long teto = subtotal * 20 / 100;
        return desconto > teto ? teto : desconto;
    }
}
