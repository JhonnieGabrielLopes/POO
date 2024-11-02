public class Aluno {
    private String nome;
    private int idade;
    private double nota_1;
    private double nota_2;
    
    public Aluno(String nome, int idade, double nota_1, double nota_2){
        this.nome = nome;
        this.idade = idade;
        this.nota_1 = nota_1;
        this.nota_2 = nota_2;
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public double getNota_1() {
        return nota_1;
    }
    public double getNota_2() {
        return nota_2;
    }
    @Override
    public String toString() {
        return "Aluno: "+nome+" de "+idade+" anos, notas: "+nota_1+" e "+nota_2+".\n";
    }
    
}
