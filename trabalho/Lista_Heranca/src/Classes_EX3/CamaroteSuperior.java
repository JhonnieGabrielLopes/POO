package Classes_EX3;

public class CamaroteSuperior extends VIP{
    private double valorADDcmt;
    
    public CamaroteSuperior(double valor, double valorAdd, double valorADDcmt){
        super(valor, valorAdd);
        this.valorADDcmt=valorADDcmt;
    }
    
    public String valorVIP(){
        double novoValor=(getValor()+getValorAdd())+valorADDcmt;
        return "Ingresso VIP - Camarote superior: R$"+novoValor;
    }
}
