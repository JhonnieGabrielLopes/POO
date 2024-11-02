import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
    public void menu(ArrayList<Aluno> alunos){
        int i=2;
        System.out.println("MENU DE OPÇÕES");
        System.out.println("-------------------------");
        System.out.println(" > [1].Cadastrar Aluno");
        if(!alunos.isEmpty()){
        System.out.println(" > ["+(i)+"].Selecionar Aluno");
        System.out.println(" > ["+(i+1)+"].Ver Alunos Cadastrados");
        i=4;}
        System.out.println(" > ["+(i)+"].Sair");
        System.out.println("-------------------------");
    }
    public void cadastraAluno(ArrayList<Aluno> alunos, Scanner in){
        boolean control1=true;
        int idade=0;
        double nota1=0.0, nota2=0.0;
        System.out.print("Digite o nome: \n\n > ");
        String nome=in.nextLine();
        System.out.println("\nDigite a idade: \n");
        do{
            try{
                System.out.print(" > ");
                idade=in.nextInt();
                in.nextLine();
                control1=false;
                if (idade<=0) {
                    System.out.println("Valor inválido para o campo: idade. Informe novamente\n");
                    control1=true;
                }
            }catch (Exception e) {
                in.nextLine();
                System.out.println("-------------------------");
                System.out.println("Insira uma entrada válida!");
                System.out.println("-------------------------");
                control1=true;
            }
        }while(control1);
        System.out.println("\nDigite a nota 01: \n");
        do{
            try{
                System.out.print(" > ");
                nota1=in.nextDouble();
                in.nextLine();
                control1=false;
                if (nota1<0) {
                    System.out.println("Valor inválido para o campo: nota1. Informe novamente\n");
                    control1=true;
                }
            }catch (Exception e) {
                in.nextLine();
                System.out.println("-------------------------");
                System.out.println("Insira uma entrada válida!");
                System.out.println("-------------------------");
                control1=true;
            }
        }while(control1);
        System.out.println("\nDigite a nota 02: \n");
        do{
            try{
                System.out.print(" > ");
                nota2=in.nextDouble();
                in.nextLine();
                control1=false;
                if (nota2<0) {
                    System.out.println("Valor inválido para o campo: nota2. Informe novamente\n");
                    control1=true;
                }
            }catch (Exception e) {
                in.nextLine();
                System.out.println("-------------------------");
                System.out.println("Insira uma entrada válida!");
                System.out.println("-------------------------");
                control1=true;
            }
        }while(control1);
        alunos.add(new Aluno(nome, idade, nota1, nota2));
        Limpar_terminal.limpar();
    }
    public void calcularMedia(ArrayList<Aluno> alunos, Aluno vartemp, Scanner in){
        double var2;
        var2=(vartemp.getNota_1()+vartemp.getNota_2())/2;
        System.out.println("-------------------------");
        System.out.println(" > Média: "+var2);
        System.out.println("-------------------------");
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void exibirStatus(ArrayList<Aluno> alunos, Aluno vartemp, Scanner in){
        System.out.println("-------------------------");
        System.out.println("Status do aluno: "+vartemp.getNome());
        System.out.println("-------------------------");
        System.out.println(" > Idade: "+vartemp.getIdade()+" anos");
        System.out.println(" > Notas: "+vartemp.getNota_1()+" e "+vartemp.getNota_2());
        if ((vartemp.getNota_1()+vartemp.getNota_2())/2>=6) {
            System.out.println(" > Situação: Aprovado");
        }else{
            System.out.println(" > Situação: Reprovado");
        }
        System.out.println("-------------------------");
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }
    public void selecionarAluno(ArrayList<Aluno> alunos, Iterator<Aluno> iter,Scanner in, Aluno vartemp, Principal mtd){
        String vartemp1, opc; int op=0; boolean control=true;
        System.out.print("Digite o nome completo do aluno: ");
        vartemp1=in.nextLine();
        iter=alunos.iterator();
        while (iter.hasNext()) {
            vartemp=iter.next();
            if (vartemp1.equalsIgnoreCase(vartemp.getNome())) {
                do {
                    do{
                        System.out.println("Aluno: "+vartemp.getNome());
                        System.out.println("-------------------------");
                        System.out.println(" > [1].Calcular média\n > [2].Exibir Status\n > [3].Voltar ao Menu");
                        System.out.println("-------------------------");
                        try{
                            System.out.print(" > ");
                            op=in.nextInt();
                            in.nextLine();
                            control=false;
                        }catch (Exception e){
                            in.nextLine();
                            System.out.println("Insira uma entrada válida!");
                            System.out.print(" > ENTER...");
                            in.nextLine();
                            Limpar_terminal.limpar();
                            control=true;
                        }
                    }while(control);
                    switch (op) {
                        case 1:
                            mtd.calcularMedia(alunos, vartemp, in);
                            break;
                        case 2:
                            mtd.exibirStatus(alunos, vartemp, in);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.print("Opção inválida. Tente novamente!\n > ENTER...");
                            in.nextLine();
                            Limpar_terminal.limpar();
                            break;
                    }
                }while(op!=3);
                break;
            }
        }
        if (!vartemp1.equalsIgnoreCase(vartemp.getNome())) {
            System.out.print("Aluno não encontrado! Deseja cadastrá-lo? (s/n)\n > ");
            opc=in.nextLine();
            if (opc.equalsIgnoreCase("s")) {
                Limpar_terminal.limpar();
                mtd.cadastraAluno(alunos, in);
            }
        }
        Limpar_terminal.limpar();
    }
    public void mostrarAluno(ArrayList<Aluno> alunos, Iterator<Aluno> iter, Aluno vartemp, Scanner in){
        iter=alunos.iterator();
        while (iter.hasNext()) {
            vartemp=iter.next();
            System.out.println(vartemp.toString());
        }
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }

    public static void main(String[] args) throws Exception {
        //inicialização 
        Scanner in = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        Iterator<Aluno> iter = alunos.iterator();
        Principal mtd = new Principal();
        //variaveis
        int opc=0;
        Aluno vartemp=null;
        boolean control=true;
        //menu de opções
        Limpar_terminal.limpar();
        do {
            do{
                mtd.menu(alunos);
                try{
                System.out.print(" > ");
                opc=in.nextInt();
                in.nextLine();
                control=false;
                }catch (Exception e){
                    in.nextLine();
                    System.out.println("Insira uma entrada válida!");
                    System.out.print(" > ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    control=true;
                }
            }while(control);
            if (alunos.isEmpty()&&opc==2) {
                opc=4;
            }
            switch (opc) {
                case 1:
                    Limpar_terminal.limpar();
                    mtd.cadastraAluno(alunos, in);
                    break;
                case 2:
                    Limpar_terminal.limpar();
                    mtd.selecionarAluno(alunos, iter, in, vartemp, mtd);
                    break;
                case 3:
                    Limpar_terminal.limpar();
                    mtd.mostrarAluno(alunos, iter, vartemp, in);
                    break;
                case 4:
                    Limpar_terminal.limpar();
                    System.out.println("Fim do programa...");
                    break;
                default:
                    System.out.print("Opção inválida. Tente novamente!\n > ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    break;
            }
        } while (opc!=4);
    }
}
