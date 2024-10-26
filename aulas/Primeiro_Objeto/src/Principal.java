public class Principal {
    public static void main(String[] args) {
        Pessoa jhonnie = new Pessoa();
        Pessoa luiz = new Pessoa();
        jhonnie.setCpf("000.111.222-33");
        jhonnie.setNome("Jhonnie Gabriel");
        jhonnie.setIdade(20);
        jhonnie.setCarropessoa(null);

        luiz.setCpf("111.222.333-44");
        luiz.setNome("Luiz Otário");
        luiz.setIdade(21);

        Carro carroLuiz = new Carro();
        carroLuiz.setModelo("Prisma");
        carroLuiz.setAno(2011);
        carroLuiz.setPlaca("ABC-0123");
        
        luiz.setCarropessoa(carroLuiz);

        System.out.println("\nNome: "+jhonnie.getNome()+"\nCPF: "+jhonnie.getCpf()+"\nIdade: "+jhonnie.getIdade());
        System.out.println("\nNome: "+luiz.getNome()+"\nCPF: "+luiz.getCpf()+"\nIdade: "+luiz.getIdade()+"\nCarro: "+carroLuiz.getModelo()+
            "\nANO: "+carroLuiz.getAno()+"\nPlaca: "+carroLuiz.getPlaca()+"\n");
    }
}
