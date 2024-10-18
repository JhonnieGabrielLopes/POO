import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int num, soma = 0, cont = 0;

        System.out.println("\nInforme números inteiros para soma, digite 0 para finalizar entrada!");
        do{
        num=in.nextInt();
            if (num==0) {
                break;
            }else{
                soma+=num;
                cont++;
            }
        }while(num!=0);
        System.out.println("\nA media dos números fornecidos é: "+(soma/cont));
        System.out.println("\n");
        in.close();
    }
}
