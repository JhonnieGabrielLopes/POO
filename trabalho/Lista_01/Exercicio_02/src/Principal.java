import java.util.Random;
import java.util.Scanner;

public class Principal {

    public void inserirNome(Jogador player01, Jogador player02, Scanner in){
        //nome dos players // insere os valores de energia e pontução quando o player é registrado
        System.out.println("Inserir nome");
        System.out.println("Este jogo necessita de dois players, para isso, insira dois nomes!");
        System.out.print(" > ");
        player01.setNome(in.nextLine());
        System.out.print(" > ");
        player02.setNome(in.nextLine());
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }

    public void danoPlayer01(Jogador player01, Jogador player02, Random random, int opcrandom, int temp, Scanner in){
        opcrandom=random.nextInt(3)+1;
        switch (opcrandom) {
            case 1:
                System.out.println("DANO COMUM\nVOCÊ CONSEGUIU FERIR SEU ADVERSÁRIO, MAS NÃO FOI UM GRANDE ATAQUE\nDANO: -10 DE ENERGIA\n");
                temp=player02.getEnergia();
                temp=temp-10;
                player02.setEnergia(temp);
                temp=player01.getPontuação();
                temp=temp+28;
                player01.setPontuacao(temp);
                break;
            case 2:
                System.out.println(" > DANO REDUZIDO\n > VOCÊ TENTOU UM ATAQUE PERSPICAZ MAS SEU ADVERSÁRIO CONSEGUIU SE DEFENDER\n > DANO: -4 DE ENERGIA\n");
                temp=player02.getEnergia();
                temp=temp-4;
                player02.setEnergia(temp);
                temp=player01.getPontuação();
                temp=temp+15;
                player01.setPontuacao(temp);
                break;
            case 3:
                System.out.println(" > DANO CRÍTICO\n > VOCÊ DESFERIU UM GOLPE PODEROSO, SEU ADVERSÁRIO NÃO SE ESQUECERÁ DELE TÃO CEDO\n > DANO: -20 DE ENERGIA\n");
                temp=player02.getEnergia();
                temp=temp-20;
                player02.setEnergia(temp);
                temp=player01.getPontuação();
                temp=temp+50;
                player01.setPontuacao(temp);
                break;
            default:
                break;
        }
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }

    public void danoPlayer02(Jogador player01, Jogador player02, Random random, int opcrandom, int temp, Scanner in){
        opcrandom=random.nextInt(3)+1;
        switch (opcrandom) {
            case 1:
                System.out.println(" > DANO COMUM\n > SEU GOLPE ATINGE O ADVERSÁRIO, MAS NÃO CAUSA TANTO EFEITO\n > DANO: -10 DE ENERGIA\n");
                temp=player01.getEnergia();
                temp=temp-10;
                player01.setEnergia(temp);
                temp=player02.getPontuação();
                temp=temp+28;
                player02.setPontuacao(temp);
                break;
            case 2:
                System.out.println(" > DANO REDUZIDO\n > VOCÊ TENTOU UM ATAQUE PERSPICAZ MAS SEU ADVERSÁRIO CONSEGUIU SE DEFENDER\n > DANO: -4 DE ENERGIA\n");
                temp=player01.getEnergia();
                temp=temp-4;
                player01.setEnergia(temp);
                temp=player02.getPontuação();
                temp=temp+15;
                player02.setPontuacao(temp);
                break;
            case 3:
                System.out.println(" > DANO CRÍTICO\n > VOCÊ DESFERIU UM GOLPE PODEROSO, SEU ADVERSÁRIO NÃO SE ESQUECERÁ DELE TÃO CEDO\n > DANO: -20 DE ENERGIA\n");
                temp=player01.getEnergia();
                temp=temp-20;
                player01.setEnergia(temp);
                temp=player02.getPontuação();
                temp=temp+50;
                player02.setPontuacao(temp);
                break;
            default:
                break;
        }
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }

    public void statusPlayer01(Jogador player01, Scanner in){
        System.out.println("STATUS");
        System.out.println("------------------------");
        System.out.println(" > Jogador: "+player01.getNome());
        System.out.println(" > Energia: "+player01.getEnergia());
        System.out.println(" > Pontuação: "+player01.getPontuação());
        System.out.println("------------------------");
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }

    public void statusPlayer02(Jogador player02, Scanner in){
        System.out.println("STATUS");
        System.out.println("------------------------");
        System.out.println(" > Jogador: "+player02.getNome());
        System.out.println(" > Energia: "+player02.getEnergia());
        System.out.println(" > Pontuação: "+player02.getPontuação());
        System.out.println("------------------------");
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }

    public boolean verificarVencendor(Boolean decisao, Jogador player01, Jogador player02, int temp, int temp2, int i, Scanner in){
        temp=player01.getEnergia();
        temp2=player02.getEnergia();
        if (temp<=0) {
            System.out.println("Vencedor\nJogador: "+player02.getNome()+"\nPontuação: "+player02.getPontuação()+"\nEnergia restante: "+player02.getEnergia()+"\nRodadas necessárias: "+i);
            System.out.print("\n > ENTER...");
            in.nextLine();
            Limpar_terminal.limpar();
            decisao=true;
        }
        if (temp2<=0) {
            System.out.println("Vencedor\nJogador: "+player01.getNome()+"\nPontuação: "+player01.getPontuação()+"\nEnergia restante: "+player01.getEnergia()+"\nRodadas necessárias: "+i);
            System.out.print("\n > ENTER...");
            in.nextLine();
            Limpar_terminal.limpar();
            decisao=true;
        }
        return decisao;
    }
    
    public void partida(Jogador player01, Jogador player02, Scanner in, Principal met){
        //------------------------------------instanciamento---------------------------------
        Random random = new Random();
        //------------------------------------Variáveis--------------------------------------
        int opcrandom=0, i=1, temp=0, temp2=0;
        boolean over=true, opcpart=true, decisao=false;
        String escolha;
        //------------------------------------Execução--------------------------------------
        System.out.println("PARTIDA INICIADA");
        player01.setEnergia(100);
        player01.setPontuacao(0);
        player02.setEnergia(100);
        player02.setPontuacao(0);
        do{
            do{
                System.out.println("RODADA "+i);
                System.out.println("Jogador 01: "+player01.getNome());
                System.out.println("--------------------------");
                System.out.println(" > Atacar - /attack ou /A\n > Status - /status | /S\n > /exit");
                System.out.println("--------------------------");
                escolha=in.nextLine().toLowerCase();
                System.out.println("");
                if (escolha.equals("/attack")||escolha.equals("/a")){
                    met.danoPlayer01(player01, player02, random, opcrandom, temp, in);
                    opcpart=false;
                }else if(escolha.equals("/status")||escolha.equals("/s")){
                    met.statusPlayer01(player01, in);
                    opcpart=true;
                }else if(escolha.equals("/exit")){
                    System.out.println(" > "+player01.getNome()+" abandonou a partida!");
                    player01.setEnergia(0);
                    System.out.print(" > ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    opcpart=false;
                }else{
                    System.out.println("Comando inválido, digite novamente!");
                    System.out.print(" > ENTER...");
                    in.nextLine();
                    Limpar_terminal.limpar();
                    opcpart=true;
                }
            }while(opcpart);
            if (met.verificarVencendor(decisao, player01, player02, temp, temp2, i, in)){
                over=false;
            }else{
                do{
                    System.out.println("RODADA "+i);
                    System.out.println("Jogador 02: "+player02.getNome());
                    System.out.println("--------------------------");
                    System.out.println(" > Atacar - /attack ou /A\n > Status - /status | /S\n > /exit");
                    System.out.println("--------------------------");
                    escolha=in.nextLine().toLowerCase();
                    System.out.println("");
                    if (escolha.equals("/attack")||escolha.equals("/a")){
                        met.danoPlayer02(player01, player02, random, opcrandom, temp, in);
                        opcpart=false;
                    }else if(escolha.equals("/status")||escolha.equals("/s")){
                        met.statusPlayer02(player02, in);
                        opcpart=true;
                    }else if(escolha.equals("/exit")){
                        System.out.println(" > "+player02.getNome()+" abandonou a partida!");
                        player02.setEnergia(0);
                        System.out.print(" > ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                        opcpart=false;
                    }else{
                        System.out.println("Comando inválido, digite novamente!");
                        System.out.print(" > ENTER...");
                        in.nextLine();
                        Limpar_terminal.limpar();
                        opcpart=true;
                    }
                }while(opcpart);
                if (met.verificarVencendor(decisao, player01, player02, temp, temp2, i, in)){
                    over=false;
                }
            }
            i++;
        }while(over);
    }
    public static void main(String[] args) throws Exception {
        //------------------------------------instanciamento---------------------------------
        Scanner in = new Scanner(System.in);
        Principal met = new Principal();
        Jogador player01 = new Jogador();
        Jogador player02 = new Jogador();
        Informacoes inf = new Informacoes();
        //------------------------------------Variáveis--------------------------------------
        int opc=0;
        boolean control=true;
        //------------------------------------menu de opções---------------------------------
        do {
            do{
                inf.menu(player01);
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
            if(player01.getNome()==null&&opc!=1){
                opc=opc+1;
            }
            switch (opc) {
                case 1:
                    Limpar_terminal.limpar();
                    met.inserirNome(player01, player02, in);
                    break;
                case 2:
                    Limpar_terminal.limpar();
                    met.partida(player01, player02, in, met);
                    break;
                case 3:
                    Limpar_terminal.limpar();
                    inf.comoJogar(in);
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
        in.close();
    }
}
