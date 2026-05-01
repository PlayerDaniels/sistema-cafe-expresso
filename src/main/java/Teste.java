package src.main.java;
public class Teste {

    public static void main(String[] args) {

        Produto cafe = new Produto("Café Expresso", 5.0);
        Produto pao = new Produto("Pão de Queijo", 7.0);

        ItemPedido item1 = new ItemPedido(cafe, 2);
        ItemPedido item2 = new ItemPedido(pao, 1);

        Pedido pedido = new Pedido();

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        
        // Exibe o pedido (sem status)
        pedido.exibirPedido();

        // Fluxo correto de status
        pedido.alterarStatus(Pedido.Status.PAGO);
        pedido.alterarStatus(Pedido.Status.EM_PREPARO);
        pedido.alterarStatus(Pedido.Status.FINALIZADO);

        // Agora exibe apenas uma vez
        System.out.println("\nStatus final: " + pedido.getStatus());
    }
}