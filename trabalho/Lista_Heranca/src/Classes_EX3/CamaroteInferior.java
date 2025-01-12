package Classes_EX3;

public class CamaroteInferior extends VIP{
    private String localizacao;

    public CamaroteInferior(double valor, double valorAdd, String localizazcao){
        super(valor, valorAdd);
        this.localizacao=localizazcao;
    }
    
    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void loc(){
        System.out.println("Localização do ingresso: "+localizacao);
    }
}
