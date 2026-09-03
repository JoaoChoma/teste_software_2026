package br.edu.cesu;

public class AnalisadorPedido {

    public String analisarPedido(
            double valor,
            boolean clienteVip,
            boolean possuiCupom,
            boolean pagamentoAprovado) {

        if (!pagamentoAprovado) {
            return "PAGAMENTO_RECUSADO";
        }

        if (valor <= 0) {
            return "VALOR_INVALIDO";
        }

        if (valor >= 500) {

            if (clienteVip) {

                if (possuiCupom) {
                    return "DESCONTO_MAXIMO";
                }

                return "DESCONTO_VIP";
            }

            if (possuiCupom) {
                return "DESCONTO_CUPOM";
            }

            return "DESCONTO_VALOR";
        }

        if (clienteVip) {
            return "DESCONTO_VIP";
        }

        return "SEM_DESCONTO";
    }
}