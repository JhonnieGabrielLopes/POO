import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Empresa {
    public void Opcoes(){
        System.out.println(" <Menu de Opções> ");
        System.out.println(" > [1].Cadastrar funcionário");
        System.out.println(" > [2].Funcionários registrados");
        System.out.println(" > [3].Calcular média salárial da empresa");
        System.out.println(" > [4].Pesquisar funcionários por cargo");
        System.out.println(" > [5].Sair");
    }
    public void cadastrarFuncionario(ArrayList<Funcionario> registro, Scanner in){
        String nome, cargo;
        double salario=0.0;
        boolean control1=true;
        System.out.println("       >> CADASTRO DE FUNCIONÁRIO <<");
        System.out.println("----------------------------------------------");
        System.out.print("Digite o nome do funcionário para cadastro: ");
        nome=in.nextLine();
        System.out.print("Digite o cargo deste funcionário: ");
        cargo=in.nextLine();
        do {
            System.out.print("Digite o salário deste funcionário: R$");
            try {
                salario=in.nextDouble();
                in.nextLine();
                control1=false;
            } catch (Exception e) {
                in.nextLine();
                System.out.println("\nEntrada inválida, digite novamente.");
                System.out.print("\nENTER...");
                in.nextLine();
                Limpar_terminal.limpar();
                control1=true;
            }
        } while (control1);
        //Atrinbuição do funcionário no registro
        registro.add(new Funcionario(nome, cargo, salario));
        System.out.println("----------------------------------------------");
        System.out.println("        >> FUNCIONÁRIO REGISTRADO <<");
        System.out.println("----------------------------------------------\n");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void puxarRegistro(ArrayList<Funcionario> registro, Iterator<Funcionario> iter, Scanner in){
    Funcionario temp;
    iter=registro.iterator();
    while (iter.hasNext()) {
        temp=iter.next();
        System.out.println(" > "+temp.getNome());
    }
    System.out.println("----------------------------------------");
    System.out.print("ENTER...");
    in.nextLine();
    Limpar_terminal.limpar();
    }
    public void calcucaMediasalarial(ArrayList<Funcionario> registro, Iterator<Funcionario> iter, Scanner in){
        Funcionario temp;
        double mediaSalarial=0; // a variavel será utilizada para armazenar a soma dos salarios e também será utilizada para receber a média
        iter=registro.iterator();
        while (iter.hasNext()) {
            temp=iter.next();
            mediaSalarial+=temp.getSalario(); // recebendo e acumulando o salário dos funcionários dentro de registro
        }
        mediaSalarial=mediaSalarial/registro.size();
        System.out.println("A média salarial atual é de: R$"+ String.format("%.2f", mediaSalarial) );
        System.out.println("----------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void buscarPorCargo(ArrayList<Funcionario> registro, Iterator<Funcionario> iter, Scanner in){
        Funcionario temp;
        String cargo;
        boolean control2=true;
        System.out.print("Digite o cargo para consulta: ");
        cargo=in.nextLine();
        iter=registro.iterator();
        while (iter.hasNext()) {
            temp=iter.next();
            if (temp.getCargo().equalsIgnoreCase(cargo)) {
                System.out.println(temp.getNome());
                control2=false;
            }
        }
        if (control2) {
            System.out.println("Não há registros de funcionários com este cargo!");
        }
        System.out.println("----------------------------------------");
        System.out.print("ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public static void main(String[] args) throws Exception {
        //limpa o conteúdo do terminal
        Limpar_terminal.limpar();
        //Inicialização
        Scanner in = new Scanner(System.in);
        Empresa mtd = new Empresa();
        ArrayList<Funcionario> registro = new ArrayList<>();
        Iterator<Funcionario> iter = registro.iterator();
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
                    mtd.cadastrarFuncionario(registro, in);
                    break;
                case 2:
                    Limpar_terminal.limpar();
                    if (!registro.isEmpty()) {
                        mtd.puxarRegistro(registro, iter, in);
                    }else{System.out.println("Não há registros de funcionários no sistema.");
                    System.out.print("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    }
                    break;
                case 3:
                    Limpar_terminal.limpar();
                    if (!registro.isEmpty()) {
                    mtd.calcucaMediasalarial(registro, iter, in);
                    }else{System.out.println("Não há registros de funcionários no sistema.");
                    System.out.print("ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    }
                    break;
                case 4:
                    Limpar_terminal.limpar();
                    if (!registro.isEmpty()) {
                    mtd.buscarPorCargo(registro, iter, in);
                    }else{System.out.println("Não há registros de funcionários no sistema.");
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