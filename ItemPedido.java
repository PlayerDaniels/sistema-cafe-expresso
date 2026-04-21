public class ItemPedido {

    // Cada item tem um produto e uma quantidade
    private Produto produto;
    private int quantidade;

    // Construtor
    public ItemPedido(Produto produto, int quantidade) {

        // Não permite quantidade menor ou igual a zero
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }

        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Calcula o subtotal (preço * quantidade)
    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    // Retorna o produto
    public Produto getProduto() {
        return produto;
    }

    // Retorna a quantidade
    public int getQuantidade() {
        return quantidade;
    }

    // Mostra o item de forma organizada (ex: 2x Café - R$ 10)
    public String exibirItem() {
        return quantidade + "x " + produto.getNome() +
               " - Subtotal: R$ " + calcularSubtotal();
    }
}