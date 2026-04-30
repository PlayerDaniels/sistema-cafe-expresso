import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    // Testa se o produto é criado corretamente com nome e preço
    @Test
    public void deveCriarProdutoCorretamente() {
        Produto cafe = new Produto("Café Expresso", 5.0);

        assertEquals("Café Expresso", cafe.getNome());
        assertEquals(5.0, cafe.getPreco());
    }

    // Testa se o subtotal do item é calculado corretamente
    @Test
    public void deveCalcularSubtotalCorretamente() {
        Produto cafe = new Produto("Café Expresso", 5.0);
        ItemPedido item = new ItemPedido(cafe, 2);

        assertEquals(10.0, item.calcularSubtotal());
    }

    // Testa se o valor total do pedido é calculado corretamente
    @Test
    public void deveCalcularTotalPedidoCorretamente() {
        Produto cafe = new Produto("Café Expresso", 5.0);
        ItemPedido item = new ItemPedido(cafe, 2);

        Pedido pedido = new Pedido();
        pedido.adicionarItem(item);

        assertEquals(10.0, pedido.calcularTotal());
    }

    // Testa se o fluxo de status do pedido ocorre corretamente
    @Test
    public void deveAlterarStatusPedidoCorretamente() {
        Pedido pedido = new Pedido();

        assertEquals(Pedido.Status.PENDENTE, pedido.getStatus());

        pedido.alterarStatus(Pedido.Status.PAGO);
        assertEquals(Pedido.Status.PAGO, pedido.getStatus());

        pedido.alterarStatus(Pedido.Status.EM_PREPARO);
        assertEquals(Pedido.Status.EM_PREPARO, pedido.getStatus());

        pedido.alterarStatus(Pedido.Status.FINALIZADO);
        assertEquals(Pedido.Status.FINALIZADO, pedido.getStatus());
    }
}
