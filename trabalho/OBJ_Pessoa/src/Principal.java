import java.util.Scanner;

public class Principal {
    
    public void exibirDetalhes(Pessoa humano01, Pessoa humano02, Scanner in){
        System.out.println("\n-------------------");
        System.out.println(humano01.toString());
        System.out.println(humano01.calculaIMC());
        System.out.println("-------------------");
        System.out.println(humano02.toString());
        System.out.println(humano02.calculaIMC());
        System.out.println("-------------------\n");
    }
    public static void main(String[] args) throws Exception {
        Limpar_terminal.limpar();
        //Inicialização
        Scanner in = new Scanner(System.in);
        Pessoa humano01 = new Pessoa();
        Pessoa humano02 = new Pessoa();
        Principal met = new Principal();
        //Variáveis
        int opc=0;
        boolean control=true;
        //Atribuição
        humano01.setPessoa("José", 25, 1.83, 86);
        humano02.setPessoa("Maria", 23, 1.68, 60);
        //Menu
        do {
            do {
                System.out.println("MENU");
                System.out.println("-------------------");
                System.out.println(" > [1].Exibir detalhes");
                System.out.println(" > [2].Sair");
                System.out.println("-------------------");
                try {
                    System.out.print("\n > ");
                    opc=in.nextInt();
                    control=false;
                } catch (Exception e) {
                    System.out.println("\nDigite um entrada válida! (DEVE SER INTEIRO)");
                    System.out.println("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    control=true;
                }
            } while (control);
            switch (opc) {
                case 1:
                    met.exibirDetalhes(humano01, humano02, in);
                    break;
                case 2:
                    System.out.println("\nFinalizando...");
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente!");
                    System.out.println("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    break;
            }
        } while (opc!=2);
        in.close();
    }
}
