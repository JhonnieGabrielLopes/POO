import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Biblioteca {
    public void Opcoes(){
        System.out.println(" <Menu de Opções> ");
        System.out.println(" > [1].Cadastrar Livro");
        System.out.println(" > [2].Exibir biblioteca");
        System.out.println(" > [3].Pesquisar livros por autor");
        System.out.println(" > [4].Pesquisar livros por ano de publicação");
        System.out.println(" > [5].Sair");
    }
    public void cadastrarLivro(ArrayList<Livro> biblioteca, Scanner in, boolean control){
        String titulo, autor;
        int dataPubli=0;
        control=true;
        System.out.println(" <Cadastrando Livro>");
        System.out.print("Digite o título do livro: ");
        titulo=in.nextLine();
        System.out.print("Digite o nome do autor deste livro: ");
        autor=in.nextLine();
        do {
            try {
                System.out.print("Digite o ano de publicação deste livro: ");
                dataPubli=in.nextInt();
                in.nextLine();
                if (dataPubli<=0 || dataPubli >2024) {
                    System.out.println("\nAno inválido! Digite novamente.");
                    System.out.print("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                }else{
                control=false;}
            } catch (Exception e) {
                control=true;
                in.nextLine();
                System.out.println("\nDigite uma entrada válida!");
                System.out.print("ENTER...");
                in.nextLine();
                Limpar_terminal.limpar();
            }
        } while (control);
        //Adicionando um novo livro na biblioteca
        biblioteca.add(new Livro(titulo, autor, dataPubli));
        System.out.println("-------------------------------------------\n");
        System.out.println(" > Livro cadastrado!\n");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void exibirBiblioteca(ArrayList<Livro> biblioteca, Scanner in, Iterator<Livro> iter){
        Livro temp;
        iter=biblioteca.iterator();
        while (iter.hasNext()) {
            temp=iter.next();
            System.out.println(temp.detalheLivro());
            System.out.println("-------------------------------------------");
        }
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void buscaPorAutor(ArrayList<Livro> biblioteca, Scanner in, Iterator<Livro> iter){
        Livro temp;
        String temp2;
        System.out.print("Digite o nome do autor para busca: ");
        temp2=in.nextLine();
        Limpar_terminal.limpar();
        iter=biblioteca.iterator();
        System.out.println("Resultados para: "+temp2);
        System.out.println("-------------------------------------------");
        while (iter.hasNext()) {
            temp=iter.next();
            if (temp.getAutor().equalsIgnoreCase(temp2)) {
                System.out.println(temp.detalheLivro());
                System.out.println("-------------------------------------------");
            }
        }
        System.out.print("\nENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void buscaPorAno(ArrayList<Livro> biblioteca, Scanner in, Iterator<Livro> iter){
        Livro temp;
        int temp2;
        System.out.print("Digite o ano de publicação para busca: ");
        temp2=in.nextInt();
        in.nextLine();
        Limpar_terminal.limpar();
        iter=biblioteca.iterator();
        System.out.println("Resultados para: "+temp2);
        System.out.println("-------------------------------------------");
        while (iter.hasNext()) {
            temp=iter.next();
            if (temp.getAnoPublicacao()==temp2) {
                System.out.println(temp.detalheLivro());
                System.out.println("-------------------------------------------");
            }
        }
        System.out.print("\nENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }

    public static void main(String[] args) throws Exception {
        //limpa o conteúdo do terminal
        Limpar_terminal.limpar();
        //Inicialização
        Scanner in = new Scanner(System.in);
        ArrayList<Livro> biblioteca = new ArrayList<>();
        Iterator<Livro> iter = biblioteca.iterator();
        Biblioteca mtd = new Biblioteca();
        //Variáveis menu
        int opc=0;
        boolean control=true;
        //Opções
        do {
            do {
                try {
                    mtd.Opcoes();
                    System.out.print(" > ");
                    opc=in.nextInt();
                    in.nextLine();
                    control=false;
                } catch (Exception e) {
                    in.nextLine();
                    System.out.println("\nDigite uma entrada válida!");
                    System.out.print("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    control=true;
                }
            } while (control);
            switch (opc) {
                case 1:
                    Limpar_terminal.limpar();
                    mtd.cadastrarLivro(biblioteca, in, control);
                    break;
                case 2:
                    Limpar_terminal.limpar();
                    if (!biblioteca.isEmpty()) {
                        mtd.exibirBiblioteca(biblioteca, in,iter);
                    }else{
                        System.out.println("Biblioteca vazia!\n");
                        System.out.print("ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                    }
                    break;
                case 3:
                    Limpar_terminal.limpar();
                    if (!biblioteca.isEmpty()) {
                        mtd.buscaPorAutor(biblioteca, in, iter);
                    }else{
                        System.out.println("Biblioteca vazia!\n");
                        System.out.print("ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                    }
                    break;
                case 4:
                    Limpar_terminal.limpar();
                    if (!biblioteca.isEmpty()) {
                        mtd.buscaPorAno(biblioteca, in, iter);
                    }else{
                        System.out.println("Biblioteca vazia!\n");
                        System.out.print("ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    System.out.println("-------------------------------------------");
                    System.out.print("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    break;
            }
        } while (opc!=5);
    }
}
