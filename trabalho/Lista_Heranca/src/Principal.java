import java.util.Scanner;

import Classes_EX1.AssistADM;
import Classes_EX1.AssistTEC;
import Classes_EX1.Assistente;
import Classes_EX1.Funcionario;
import Classes_EX2.Cachorro;
import Classes_EX2.Gato;

public class Principal {
    public void menu(){
        System.out.println("\nExercícios de Herança em Java");
        System.out.println("================================");
        System.out.println(" [1].Assistente ADM e Técnico");
        System.out.println(" [2].Cão e Gato");
        System.out.println(" [3].Rico, Pobre e Miserável");
        System.out.println(" [4].Ingressos VIP e Comum");
        System.out.println(" [5].Imóvel");
        System.out.println(" [6].Sair");
        System.out.println("================================");
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Principal mtd = new Principal();
        boolean controle=true;
        int opc=0;
        //teste de  menu e acesso
        
        do{
            do {
                mtd.menu();
                try {
                    System.out.print(" > ");
                    opc=in.nextInt();
                    System.out.println();
                    in.nextLine();
                    controle=false;
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Tente novamente.\n");
                    controle=true;
                }
            } while (controle);
            switch (opc) {
                case 1:
                    AssistADM adm = new AssistADM("Amanda", 2.200, "A247324", "dia", 0);
                    AssistTEC tec = new AssistTEC("Lucas", 3.320, "T262334", 520);
                    adm.exibeDados();
                    System.out.println("");
                    tec.exibeDados();
                case 2:
                    Cachorro cao = new Cachorro();
                    Gato gato = new Gato();
                    System.out.println(cao.latir());
                    System.out.println(gato.miar());
                    System.out.println(cao.caminha());
                    System.out.println(gato.caminha());
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                default:
                    break;
            }
        }while(opc!=6);
    }
}
