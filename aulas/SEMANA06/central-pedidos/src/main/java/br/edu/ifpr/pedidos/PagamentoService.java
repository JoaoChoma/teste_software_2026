package br.edu.ifpr.pedidos;

import java.util.Objects;

public class PagamentoService {
    private final ProcessadorPagamento processador;

    public PagamentoService(ProcessadorPagamento processador) {
        this.processador = Objects.requireNonNull(processador);
    }

    public boolean pagar(long total, int maxTentativas) {
        if (total <= 0) throw new IllegalArgumentException("Total deve ser positivo");
        if (maxTentativas < 1 || maxTentativas > 3) throw new IllegalArgumentException("Use 1 a 3 tentativas");
        int tentativa = 0;
        do {
            tentativa++;
            try {
                return processador.autorizar(total);
            } catch (IllegalStateException indisponivel) {
                // Apenas indisponibilidade temporária permite nova tentativa.
            }
        } while (tentativa < maxTentativas);
        return false;
    }
}
