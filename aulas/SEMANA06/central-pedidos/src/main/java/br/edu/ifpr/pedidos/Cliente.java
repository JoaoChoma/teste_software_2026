package br.edu.ifpr.pedidos;

public record Cliente(boolean vip, boolean bloqueado, int comprasAnteriores) {
    public Cliente {
        if (comprasAnteriores < 0) throw new IllegalArgumentException("Histórico inválido");
    }
}
