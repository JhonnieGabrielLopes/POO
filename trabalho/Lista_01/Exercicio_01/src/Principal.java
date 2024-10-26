import java.util.Scanner;

public class Principal {

    public void menu(){
        System.out.println("\n > Opções\n > [1]. Exibir detalhes\n > [2]. Valor total dos produtos\n > [3]. Sair");
        System.out.print("---------------------------------\n > ");
    }

    public void exibirDetalhes(Produto prod01, Produto prod02, Produto prod03, Produto prod04, Scanner in){
        System.out.println(" > DETALHES");
        System.out.println("----------------------");
        System.out.println(prod01.toString()+"\n");
        System.out.println(prod02.toString()+"\n");
        System.out.println(prod03.toString()+"\n");
        System.out.println(prod04.toString());
        System.out.println("----------------------");
        System.out.println("Enter para retornar...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void calcularValorTotal(Produto prod01, Produto prod02, Produto prod03, Produto prod04, Scanner in){

        double soma=((prod01.getPreco()*prod01.getQuantidade())+(prod02.getPreco()*prod02.getQuantidade())+
        (prod03.getPreco()*prod03.getQuantidade())+(prod04.getPreco()*prod04.getQuantidade()));

        System.out.println("Totalização");
        System.out.println("----------------------");
        System.out.println("Água: R$"+String.format("%.2f", prod01.getPreco()*prod01.getQuantidade()));
        System.out.println("Coca-cola: R$"+String.format("%.2f",prod02.getPreco()*prod02.getQuantidade()));
        System.out.println("Doritos: R$"+String.format("%.2f",prod03.getPreco()*prod03.getQuantidade()));
        System.out.println("Negresco: R$"+String.format("%.2f",prod04.getPreco()*prod04.getQuantidade()));
        System.out.println("----------------------");
        System.out.println("Total: R$"+String.format("%.2f",soma));
        System.out.println("----------------------");
        System.out.println("Enter para retornar...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Principal met = new Principal();
        int opc;

        Produto prod01 = new Produto();
        Produto prod02 = new Produto();
        Produto prod03 = new Produto();
        Produto prod04 = new Produto();

        prod01.setdados("Água", 12, 1.09);
        prod02.setdados("Coca-cola", 6, 2.49);
        prod03.setdados("Doritos", 8, 8.99);
        prod04.setdados("Negresco", 9, 2.48);

        do{
            met.menu();
            opc=in.nextInt();
            in.nextLine();
            System.out.println("");
            switch (opc) {
                case 1:
                    Limpar_terminal.limpar();
                    met.exibirDetalhes(prod01,prod02,prod03,prod04,in);
                    break;
                case 2:
                    met.calcularValorTotal(prod01, prod02, prod03, prod04,in);
                    break;
                case 3:
                    System.out.println("FIM DO PROGRAMA...");
                    break;
                default:
                Limpar_terminal.limpar();
                System.out.println("----------------------------------");
                System.out.println("Opção inválida, digite novamente!");
                System.out.println("----------------------------------");
                    break;
            }
        }while(opc!=3);
        in.close();
    }
}