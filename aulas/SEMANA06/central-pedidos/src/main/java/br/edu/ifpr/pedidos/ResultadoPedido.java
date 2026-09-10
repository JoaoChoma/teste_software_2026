package br.edu.ifpr.pedidos;

public record ResultadoPedido(String status, long subtotalCentavos,
                              long descontoCentavos, long freteCentavos, long totalCentavos) { }
