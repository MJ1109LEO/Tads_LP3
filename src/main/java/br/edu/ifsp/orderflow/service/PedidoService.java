package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;

public class PedidoService {

    private IEstoqueService estoqueService;

    public PedidoService(IEstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    public Pedido processar (Pedido pedido){
        boolean foiReservado = this.estoqueService.reservar(pedido);
        // Verifica a reservar
        if(!foiReservado){
            pedido.marcarCancelado();
            // Salvar o pedido
            return pedido;
        }
        //Processar pagamento

        // Salvar se o pagamento teve exito.

        // Notificar o cliente.

        // Retorna o pedido
        return pedido;
    }
}
