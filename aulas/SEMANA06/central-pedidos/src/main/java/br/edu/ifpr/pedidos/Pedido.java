package br.edu.ifpr.pedidos;

import java.util.List;

public record Pedido(List<ItemPedido> itens, String uf, boolean expresso, String cupom) {
    public Pedido {
        if (itens == null || itens.size() > 100) throw new IllegalArgumentException("Lista inválida");
        itens = List.copyOf(itens);
        if (uf == null || !uf.matches("[A-Z]{2}")) throw new IllegalArgumentException("UF inválida");
    }

    public long subtotalCentavos() {
        long subtotal = 0;
        for (ItemPedido item : itens) {
            if (item.quantidade() == 0) continue;
            subtotal += item.totalCentavos();
        }
        return subtotal;
    }

    public int pesoGramas() {
        int peso = 0;
        for (ItemPedido item : itens) peso += item.pesoGramas() * item.quantidade();
        return peso;
    }

    public boolean temFragil() {
        for (ItemPedido item : itens) {
            if (item.quantidade() > 0 && item.fragil()) return true;
        }
        return false;
    }

    public boolean estoqueSuficiente() {
        boolean suficiente = true;
        for (ItemPedido item : itens) {
            if (!item.disponivel()) {
                suficiente = false;
                break;
            }
        }
        return suficiente;
    }
}
