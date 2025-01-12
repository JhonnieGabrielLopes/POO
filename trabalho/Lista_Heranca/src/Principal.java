import java.util.Scanner;
import Classes_EX1.AssistADM;
import Classes_EX1.AssistTEC;
import Classes_EX2.Cachorro;
import Classes_EX2.Gato;
import Classes_EX2.Miseravel;
import Classes_EX2.Pobre;
import Classes_EX2.Rica;
import Classes_EX3.CamaroteInferior;
import Classes_EX3.CamaroteSuperior;
import Classes_EX3.Ingresso;
import Classes_EX3.Normal;
import Classes_EX4.Imovel;
import Classes_EX4.Novo;
import Classes_EX4.Velho;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        //A
        System.out.println();
        AssistADM adm = new AssistADM("Amanda", 2.200, "A247324", "dia", 0);
        AssistTEC tec = new AssistTEC("Lucas", 3.320, "T262334", 520);
        adm.exibeDados();
        tec.exibeDados();
        System.out.println();
        //B
        Cachorro cao = new Cachorro();
        Gato gato = new Gato();
        System.out.println(cao.latir());
        System.out.println(gato.miar());
        System.out.println(cao.caminha());
        System.out.println(gato.caminha());
        System.out.println();
        //C
        Pobre var1 = new Pobre();
        Rica var2 = new Rica();
        Miseravel var3 = new Miseravel();
        var1.trabalha();
        var2.fazCompras();
        var3.mendiga();
        //D
        System.out.println();
        Ingresso ingresso = new Ingresso(100);
        System.out.println("Qual o tipo de ingresso: [1].Normal [2].VIP");
        int opc=in.nextInt();
        if (opc==1) {
            Normal ingressoNormal = new Normal(100);
            ingressoNormal.valorNormal();
            ingressoNormal.imprimeValor();
        }else if (opc==2) {
            System.out.println("Qual tipo de VIP: [1].Camarote superior [2].Camarote inferior");
            opc=in.nextInt();
            if (opc==1) {
                CamaroteSuperior ingressoCmSp = new CamaroteSuperior(100, 80, 50);
                System.out.println(ingressoCmSp.valorVIP());
            }else if (opc==2){
                CamaroteInferior ingressoCmIf = new CamaroteInferior(100, 80, "Setor sul");
                System.out.println("Ingresso VIP - Camarote Inferior: R$"+(ingressoCmIf.getValor()+ingressoCmIf.getValorAdd()));
            }
        }
        //E
        System.out.println();
        Imovel casa = new Imovel("Rua A 111, Paracatu", 250555);
        System.out.println("Qual tipo de Imovel: [1].Novo [2].Velho");
        opc=in.nextInt();
        if (opc==1) {
            Novo casaNova = new Novo("Rua B 666, Paracatu", 250555, 15000);
            System.out.println("Valor do Imóvel: R$"+String.format("%.2f",(casaNova.getPreco()+casaNova.getAdicional())));
        }else if (opc==2) {
            Velho casaVelha = new Velho("Rua K 999, Paracatu", 250555, 12000);
            System.out.println("Valor do Imóvel: R$"+String.format("%.2f",(casaVelha.getPreco()-casaVelha.getDesconto())));
        }
        in.close();
    }
}
