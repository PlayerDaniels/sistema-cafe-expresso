import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public enum Status {
        PENDENTE,
        PAGO,
        EM_PREPARO,
        FINALIZADO
    }

    private List<ItemPedido> itens;
    private Status status;

    // ✅ Sempre começa como PENDENTE
    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = Status.PENDENTE;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public Status getStatus() {
        return status;
    }

    public void alterarStatus(Status novoStatus) {
        switch (status) {

            case PENDENTE:
                if (novoStatus == Status.PAGO) {
                    status = novoStatus;
                }
                break;

            case PAGO:
                if (novoStatus == Status.EM_PREPARO) {
                    status = novoStatus;
                }
                break;

            case EM_PREPARO:
                if (novoStatus == Status.FINALIZADO) {
                    status = novoStatus;
                }
                break;

            default:
                throw new IllegalStateException("Transição inválida");
        }
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    // ✅ Agora exibe só os itens e o total (sem status)
    public void exibirPedido() {
        System.out.println("=== PEDIDO ===");
        for (ItemPedido item : itens) {
            System.out.println(item.exibirItem());
        }
        System.out.println("-----------------");
        System.out.println("Total: R$ " + calcularTotal());
    }
}