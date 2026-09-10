package br.edu.ifpr.pedidos;

@FunctionalInterface
public interface ProcessadorPagamento {
    /** Retorna true para aprovação, false para recusa definitiva.
     * IllegalStateException representa indisponibilidade temporária. */
    boolean autorizar(long totalCentavos);
}
