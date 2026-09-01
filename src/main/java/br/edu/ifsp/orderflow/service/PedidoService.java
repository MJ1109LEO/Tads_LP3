package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.ResultadoPagamento;

public class PedidoService {

    private final IEstoqueService estoqueService;
    private final IPedidoRepository pedidoRepository;
    private final IPagamentoGateway pagamentoGateway;
    private final INotificacaoService notificacaoService;

    public PedidoService(
            IEstoqueService estoqueService,
            IPedidoRepository pedidoRepository,
            IPagamentoGateway pagamentoGateway,
            INotificacaoService notificacaoService
    ) {
        this.estoqueService = estoqueService;
        this.pedidoRepository = pedidoRepository;
        this.pagamentoGateway = pagamentoGateway;
        this.notificacaoService = notificacaoService;
    }

    public Pedido processar (Pedido pedido){
        boolean foiReservado = this.estoqueService.reservar(pedido);
        // Verifica a reservar
        if(!foiReservado){
            pedido.marcarCancelado();
            this.pedidoRepository.save(pedido);
            return pedido;
        }
        //Processar pagamento
        ResultadoPagamento resultado = this.pagamentoGateway.pagar(pedido);

        // Salvar se o pagamento teve exito.
        if(!resultado.isAprovado()){
            this.estoqueService.liberar(pedido);
            pedido.marcarCancelado();
            this.pedidoRepository.save(pedido);
            return pedido;
        }

        // Salvar se o pagamento teve exito.
        pedido.marcarComoPago();
        this.pedidoRepository.save(pedido);

        // Notificar o cliente.
        this.notificacaoService.notificar(
                pedido.getCliente(),
                "Pagamento Aprovado!! "+ pedido.getIdCurto() +" Confirmado"
        );

        // Retorna o pedido
        return pedido;
    }
}
