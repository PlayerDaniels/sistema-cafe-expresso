// Classe responsável por testar o funcionamento do sistema Café Expresso
public class PedidoTest {

    public static void main(String[] args) {

        System.out.println("=== INICIANDO TESTES DO SISTEMA CAFÉ EXPRESSO ===");

        // ===== TESTE 1: PRODUTO =====
        // Verifica se o produto está sendo criado corretamente
        Produto cafe = new Produto("Café Expresso", 5.0);

        if (!cafe.getNome().equals("Café Expresso")) {
            System.out.println("Erro: Nome do produto incorreto");
        }

        if (cafe.getPreco() != 5.0) {
            System.out.println("Erro: Preço do produto incorreto");
        }


        // ===== TESTE 2: ITEM PEDIDO =====
        // Verifica o cálculo do subtotal (preço * quantidade)
        ItemPedido item = new ItemPedido(cafe, 2);

        double esperadoSubtotal = 10.0;

        if (item.calcularSubtotal() != esperadoSubtotal) {
            System.out.println("Erro: Subtotal do item incorreto");
        }


        // ===== TESTE 3: PEDIDO =====
        // Verifica o cálculo do total do pedido
        Pedido pedido = new Pedido();
        pedido.adicionarItem(item);

        double esperadoTotal = 10.0;

        if (pedido.calcularTotal() != esperadoTotal) {
            System.out.println("Erro: Total do pedido incorreto");
        }


        // ===== TESTE 4: STATUS DO PEDIDO =====
        // Verifica o fluxo de status do pedido (PENDENTE → PAGO → EM_PREPARO → FINALIZADO)
        if (pedido.getStatus() != Pedido.Status.PENDENTE) {
            System.out.println("Erro: Status inicial deveria ser PENDENTE");
        }

        pedido.alterarStatus(Pedido.Status.PAGO);

        if (pedido.getStatus() != Pedido.Status.PAGO) {
            System.out.println("Erro: Status não mudou para PAGO");
        }

        pedido.alterarStatus(Pedido.Status.EM_PREPARO);
        pedido.alterarStatus(Pedido.Status.FINALIZADO);


        if (pedido.getStatus() != Pedido.Status.FINALIZADO) {
            System.out.println("Erro: Fluxo de status incorreto");
        }


        // ===== FINAL =====
        // Exibe resultado final dos testes
        System.out.println("=== TESTES FINALIZADOS ===");
        System.out.println("Status final do pedido: " + pedido.getStatus());
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
    }
}