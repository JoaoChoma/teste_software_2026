package br.edu.exemplo;

public class PedidoService {
    private final EstoqueService estoqueService;

    public PedidoService(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    public boolean realizarPedido(int quantidade) {
        if (!estoqueService.temEstoque(quantidade))
            return false;
        estoqueService.retirar(quantidade);
        return true;
    }
}