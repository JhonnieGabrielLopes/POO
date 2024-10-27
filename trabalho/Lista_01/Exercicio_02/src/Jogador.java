public class Jogador {
    private String nome;
    private int pontuação;
    private int energia;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPontuacao(int pontuação){
        this.pontuação = pontuação;
    }
    public void setEnergia(int energia){
        this.energia = energia;
    }
    public String getNome() {
        return nome;
    }
    public int getPontuação() {
        return pontuação;
    }
    public int getEnergia() {
        return energia;
    }
}
