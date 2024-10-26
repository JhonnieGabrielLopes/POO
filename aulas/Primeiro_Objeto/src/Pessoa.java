public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private Carro carropessoa;
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setIdade(int idade){
        this.idade=idade;
    }
    public int getIdade(){
        return this.idade;
    }

    public void setCpf(String cpf){
        this.cpf=cpf;
    }
    public String getCpf(){
        return this.cpf;
    }

    public void setCarropessoa(Carro carropessoa){
        this.carropessoa=carropessoa;
    }
    public Carro getCarropessoa(){
        return this.carropessoa;
    }
}
