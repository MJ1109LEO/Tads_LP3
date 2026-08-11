package br.edu.ifsp.orderflow.domain;

public class ItemPedido {
    private final int qtd;
    private final Produto produto;

    public ItemPedido(int qtd, Produto produto) {
        this.qtd = qtd;
        this.produto = produto;
    }
    public int getQtd() {
        return qtd;
    }
    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return this.produto.getNome() + "Quantidade: " + this.qtd;
    }
}
