package br.edu.ifpr.pedidos;

public class AnaliseRisco {
    public String avaliar(Cliente cliente, long total, boolean expresso) {
        if (total < 0) throw new IllegalArgumentException("Total negativo");
        if (cliente.bloqueado()) return "RECUSADO";
        if (cliente.comprasAnteriores() == 0) {
            if (total > 100_000 || expresso) return "REVISAO";
        } else if (total > 500_000 && !cliente.vip()) {
            return "REVISAO";
        }
        return "APROVADO";
    }
}
