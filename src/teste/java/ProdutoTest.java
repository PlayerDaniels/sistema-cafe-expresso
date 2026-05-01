import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void deveCriarProdutoComSucesso() {
        Produto p = new Produto("Café", 5.0);
        assertEquals("Café", p.getNome());
        assertEquals(5.0, p.getPreco());
    }

    @Test
    void deveLancarExcecaoParaNomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Produto(null, 5.0));
    }

    @Test
    void deveLancarExcecaoParaNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("", 5.0));
    }

    @Test
    void deveLancarExcecaoParaPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("Café", -1.0));
    }

    @Test
    void deveAceitarPrecoZero() {
        Produto p = new Produto("Água", 0.0);
        assertEquals(0.0, p.getPreco());
    }
}
