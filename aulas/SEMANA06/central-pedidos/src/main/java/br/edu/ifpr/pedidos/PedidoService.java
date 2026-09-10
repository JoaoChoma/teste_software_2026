package br.edu.ifpr.pedidos;

import java.util.Objects;

public class PedidoService {
    private final PoliticaDesconto descontos = new PoliticaDesconto();
    private final CalculadoraFrete fretes = new CalculadoraFrete();
    private final AnaliseRisco risco = new AnaliseRisco();
    private final PagamentoService pagamentos;

    public PedidoService(ProcessadorPagamento processador) {
        pagamentos = new PagamentoService(processador);
    }

    public ResultadoPedido fechar(Pedido pedido, Cliente cliente) {
        Objects.requireNonNull(pedido);
        Objects.requireNonNull(cliente);
        if (cliente.bloqueado()) return semCobranca("BLOQUEADO");
        long subtotal = pedido.subtotalCentavos();
        if (subtotal == 0) throw new IllegalArgumentException("Pedido sem itens ativos");
        if (!pedido.estoqueSuficiente()) return semCobranca("SEM_ESTOQUE");
        long desconto = descontos.calcular(cliente, subtotal, pedido.cupom());
        long liquido = subtotal - desconto;
        long frete = fretes.calcular(pedido, cliente, liquido);
        long total = liquido + frete;
        String analise = risco.avaliar(cliente, total, pedido.expresso());
        if (!analise.equals("APROVADO")) {
            return new ResultadoPedido(analise, subtotal, desconto, frete, total);
        }
        String status = pagamentos.pagar(total, 3) ? "PAGO" : "PAGAMENTO_RECUSADO";
        return new ResultadoPedido(status, subtotal, desconto, frete, total);
    }

    private ResultadoPedido semCobranca(String status) {
        return new ResultadoPedido(status, 0, 0, 0, 0);
    }
}
