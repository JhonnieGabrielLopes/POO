package Classes_EX4;

public class Novo extends Imovel{
    private double adicional;

    public Novo(String endereco, double preco, double adicional){
        super(endereco, preco);
        this.adicional=adicional;
    }

    public double getAdicional() {
        return adicional;
    }

    public void setAdicional(double adicional) {
        this.adicional = adicional;
    }
    
    public void mostraAdicional(){
        System.out.println("R$"+adicional);
    }
}
