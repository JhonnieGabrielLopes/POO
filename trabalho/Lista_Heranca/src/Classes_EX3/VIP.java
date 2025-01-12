package Classes_EX3;

public class VIP extends Ingresso{
    private double valorAdd;

    public VIP(double valor, double valorAdd){
        super(valor);
        this.valorAdd=valorAdd;
    }

    public double getValorAdd() {
        return valorAdd;
    }

    public void setValorAdd(double valorAdd) {
        this.valorAdd = valorAdd;
    }

    public String valorVIP(){
        double novoValor=super.getValor()+valorAdd;
        return "Ingresso VIP: R$"+novoValor;
    }
}
