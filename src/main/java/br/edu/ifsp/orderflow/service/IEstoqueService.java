package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;

public interface IEstoqueService {

    /**
     * Repõe o estoque.
     *
     * @param produto
     * @param qtd
     * return void
     */
    public void adicionarEstoque (Produto produto, int qtd);

    /**
     *Quantidade disponivel para o produto
     *
     * @param produto
     * @return int
     */
    public int quantidadeDisponivel(Produto produto);

    /**
     *Tenta reservar o estoque de todos os itens do pedido
     *
     * @param pedido
     * @return
     */

    public boolean reservar(Pedido pedido);

    /**
     *Devolve ao estoque os itens de um pedido (ex.: Pagamento recusado)
     * @param pedido
     * @return
     */


    public void liberar(Pedido pedido);
}
