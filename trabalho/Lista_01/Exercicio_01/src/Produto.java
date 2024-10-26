public class Produto {
    private String nome;
    private double preco; // vs code não aceitou os valores de preço como variável float, por isso o uso de double
    private int quantidade;
    
    public void setdados(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    @Override
    public String toString() {
        return "Produto: "+nome+"\nPreco: R$"+preco+"\nQuantidade: "+quantidade;
    }
}
