package br.edu.ifsp.orderflow;


import br.edu.ifsp.orderflow.domain.Cliente;
import br.edu.ifsp.orderflow.domain.ItemPedido;
import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;
import br.edu.ifsp.orderflow.infra.InMemoryEstoqueService;
import br.edu.ifsp.orderflow.service.IEstoqueService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        IEstoqueService estoqueService = new InMemoryEstoqueService();

        Produto mouse = new Produto(
                "SKU-1",
                "Mouse sem fio",
                new BigDecimal("120.00")
        );

        Produto teclado = new Produto(
                "SKU-2",
                "Teclado Mecânico",
                new BigDecimal("350.00")
        );

        Produto monitor = new Produto(
                "SKU-3",
                "Monitor 27 pol",
                new BigDecimal("1800.00")
        );

        estoqueService.adicionarEstoque(mouse, 10);
        estoqueService.adicionarEstoque(teclado, 8);
        estoqueService.adicionarEstoque(monitor, 5);

        Cliente ana = new Cliente("Ana","ana@gmail.com");
        Cliente may = new Cliente("Mayara","may@gmail.com");

        Pedido pedido1 = new Pedido(ana);
        pedido1.adicionarItem(new ItemPedido(mouse,2));
        pedido1.adicionarItem(new ItemPedido(teclado,4));

        boolean reservado = estoqueService.reservar(pedido1);

        if(reservado == false){
            System.out.println("Não reservado!!");
        }else{
            System.out.println("Reservado!!");
        }

        Pedido pedido2 = new Pedido(may);
        pedido2.adicionarItem(new ItemPedido(monitor,2));
        pedido2.adicionarItem(new ItemPedido(teclado,10));

        System.out.println(pedido1);
    }
}
