public class Hospede {
    private String cpf;
    private String endereco;
    private String telefone;
    
    
    public Hospede(String cpf, String endereco, String telefone) {
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTelefone() {
        return telefone;
    }    
}
