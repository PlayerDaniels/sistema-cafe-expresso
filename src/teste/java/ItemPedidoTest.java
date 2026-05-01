
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemPedidoTest {

    @Test
    void deveCriarItemComSucesso() {
        Produto p = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(p, 2);
        assertEquals(2, item.getQuantidade());
        assertEquals(p, item.getProduto());
    }

    @Test
    void deveCalcularSubtotalCorretamente() {
        Produto p = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(p, 3);
        assertEquals(15.0, item.calcularSubtotal());
    }

    @Test
    void deveLancarExcecaoParaQuantidadeZero() {
        Produto p = new Produto("Café", 5.0);
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido(p, 0));
    }

    @Test
    void deveLancarExcecaoParaQuantidadeNegativa() {
        Produto p = new Produto("Café", 5.0);
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido(p, -1));
    }

    @Test
    void deveExibirItemFormatado() {
        Produto p = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(p, 2);
        String resultado = item.exibirItem();
        assertTrue(resultado.contains("Café"));
        assertTrue(resultado.contains("10.0"));
    }
}

