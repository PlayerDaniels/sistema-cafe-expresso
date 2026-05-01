package src.main.java;
public class Produto {

    // Atributos do produto
    private String nome;
    private double preco;

    // Construtor: usado para criar um produto já com nome e preço
    public Produto(String nome, double preco) {

        // Validação: não permite nome vazio
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        // Validação: não permite preço negativo
        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }

        // Atribuição dos valores
        this.nome = nome;
        this.preco = preco;
    }

    // Retorna o nome do produto
    public String getNome() {
        return nome;
    }

    // Retorna o preço do produto
    public double getPreco() {
        return preco;
    }
}