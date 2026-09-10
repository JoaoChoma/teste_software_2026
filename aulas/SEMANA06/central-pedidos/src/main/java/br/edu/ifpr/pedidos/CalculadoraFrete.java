package br.edu.ifpr.pedidos;

public class CalculadoraFrete {
    public long calcular(Pedido pedido, Cliente cliente, long liquido) {
        if (liquido < 0) throw new IllegalArgumentException("Valor líquido negativo");
        long frete;
        switch (pedido.uf()) {
            case "PR": frete = 1_200; break;
            case "SP":
            case "RJ": frete = 2_000; break;
            default: frete = 3_000;
        }
        int excedente = pedido.pesoGramas() - 2_000;
        while (excedente > 0) {
            frete += 300;
            excedente -= 1_000;
        }
        if (liquido >= 30_000 && !pedido.expresso()) frete = 0;
        if (cliente.vip()) frete /= 2;
        if (pedido.expresso()) frete += 1_500;
        if (pedido.temFragil()) frete += 500;
        return frete;
    }
}
