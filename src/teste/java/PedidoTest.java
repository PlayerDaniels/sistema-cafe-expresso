

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void deveIniciarComStatusPendente() {
        Pedido pedido = new Pedido();
        assertEquals(Pedido.Status.PENDENTE, pedido.getStatus());
    }

    @Test
    void deveCalcularTotalCorretamente() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido(new Produto("Café", 5.0), 2));   // 10.0
        pedido.adicionarItem(new ItemPedido(new Produto("Pão", 7.0), 1));    // 7.0
        assertEquals(17.0, pedido.calcularTotal());
    }

    @Test
    void deveRetornarZeroParaPedidoVazio() {
        Pedido pedido = new Pedido();
        assertEquals(0.0, pedido.calcularTotal());
    }

    @Test
    void deveAlterarStatusNoFluxoCorreto() {
        Pedido pedido = new Pedido();
        pedido.alterarStatus(Pedido.Status.PAGO);
        assertEquals(Pedido.Status.PAGO, pedido.getStatus());

        pedido.alterarStatus(Pedido.Status.EM_PREPARO);
        assertEquals(Pedido.Status.EM_PREPARO, pedido.getStatus());

        pedido.alterarStatus(Pedido.Status.FINALIZADO);
        assertEquals(Pedido.Status.FINALIZADO, pedido.getStatus());
    }

    @Test
    void deveIgnorarTransicaoInvalida() {
        Pedido pedido = new Pedido(); // PENDENTE
        pedido.alterarStatus(Pedido.Status.EM_PREPARO); // transição inválida
        assertEquals(Pedido.Status.PENDENTE, pedido.getStatus()); // continua PENDENTE
    }

    @Test
    void deveLancarExcecaoAoAlterarStatusFinalizado() {
        Pedido pedido = new Pedido();
        pedido.alterarStatus(Pedido.Status.PAGO);
        pedido.alterarStatus(Pedido.Status.EM_PREPARO);
        pedido.alterarStatus(Pedido.Status.FINALIZADO);
        assertThrows(IllegalStateException.class,
            () -> pedido.alterarStatus(Pedido.Status.PAGO));
    }

    @Test
    void deveAdicionarItensAoPedido() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido(new Produto("Café", 5.0), 1));
        assertEquals(1, pedido.getItens().size());
    }
}

