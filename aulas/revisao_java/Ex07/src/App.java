import java.util.Scanner;

public class App {
    public String converter(int num){
        int resto;
        StringBuilder binario = new StringBuilder();

        if (num==0) {
            return "0";
        }
        while (num>0) {
            resto=num%2;
            binario.insert(0, resto);
            num=num/2;
        }
     return binario.toString();   
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        App metodo = new App();
        int numero, opc;
        String numbinario;
        do{
            System.out.print("\nDigite um número decimal: \n > ");
            numero=in.nextInt();
            numbinario=metodo.converter(numero);
            System.out.println("\nO número "+numero+" em binário é "+numbinario+"\n");
            System.out.println("Digite 1 para fazer outra converção ou 0 para encerrar");
            System.out.print(" > ");
            opc=in.nextInt();
        }while(opc==1);
        System.out.println("\nFIM DO PROGRAMA!\n");
        in.close();
    }
}
