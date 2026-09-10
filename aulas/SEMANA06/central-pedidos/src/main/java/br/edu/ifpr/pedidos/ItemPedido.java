package br.edu.ifpr.pedidos;

public record ItemPedido(String sku, long precoCentavos, int quantidade,
                         int estoque, int pesoGramas, boolean fragil) {
    public ItemPedido {
        if (sku == null || sku.isBlank()) throw new IllegalArgumentException("SKU obrigatório");
        if (precoCentavos <= 0 || precoCentavos > 1_000_000) throw new IllegalArgumentException("Preço inválido");
        if (quantidade < 0 || quantidade > 100) throw new IllegalArgumentException("Quantidade inválida");
        if (estoque < 0) throw new IllegalArgumentException("Estoque inválido");
        if (pesoGramas <= 0 || pesoGramas > 100_000) throw new IllegalArgumentException("Peso inválido");
    }

    public long totalCentavos() {
        return precoCentavos * quantidade;
    }

    public boolean disponivel() {
        return quantidade <= estoque;
    }
}
