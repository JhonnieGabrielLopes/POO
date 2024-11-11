public class Pessoa { 
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public double getAltura() {
        return altura;
    }
    public double getPeso() {
        return peso;
    }
    public void setPessoa(String nome, int idade, double altura, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }
    public String calculaIMC(){
        return "IMC: "+String.format("%.2f",(peso/Math.pow(altura, 2)));
    }
    @Override
    public String toString() {
        return "Nome: "+nome+"\nIdade: "+idade+" anos\nAltura: "+altura+"m\nPeso: "+peso+"Kg";
    }
    
    
}
