package Classes_EX1;

public class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario){
        this.nome=nome;
        this.salario=salario;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        this.salario=salario;
    }
    
    public void addAumento(double valor){
        //entendendo que seja apenas um aumento no salário do funcionário
        salario=salario+valor;
    }

    public String ganhoAnual(){
        String ganho="Funcionário: "+nome+"\nGanho anual: R$"+(salario*12);
        return ganho;
    }
    
    public void exibeDados(){
        System.out.println("Funcionário: "+nome+"\nSalário: R$"+salario);        
    }

}
