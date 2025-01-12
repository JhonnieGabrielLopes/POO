package Classes_EX1;

public class AssistTEC extends Assistente{
    private double bonus;

    public AssistTEC(String nome, double salario, String matricula, double bonus){
        super(nome, salario, matricula);
        this.bonus=bonus;
    } 

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    } 
    
    @Override
    public String ganhoAnual(){
        salario=salario+bonus;
        String ganho="Funcionário: "+nome+"\nGanho anual: R$"+((salario*12));
        return ganho;
    }
}
