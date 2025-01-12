package Classes_EX1;

public class AssistADM extends Assistente {
    private String turno;
    private double addNoturno;

    public AssistADM (String nome, double salario, String matricula, String turno, double addNoturno){
        super(nome, salario, matricula);
        this.turno=turno;
        this.addNoturno=addNoturno;
    } 

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getAddNoturno() {
        return addNoturno;
    }

    public void setAddNoturno(double addNoturno) {
        this.addNoturno = addNoturno;
    }

    @Override     
    public String ganhoAnual(){
        salario=salario+addNoturno;
        String ganho="Funcionário: "+nome+"\nGanho anual: R$"+((salario*12));
        return ganho;
    }
}
