import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String entrada;
        int cont=0;
        String vogal="aeiouAEIOU";
        System.out.println("\nDigite uma palavra ou frase");
        entrada=in.nextLine();

        for (int i=0; i<entrada.length(); i++) {
            char letra=entrada.charAt(i);
            if (vogal.indexOf(letra)!=-1){
                cont++;
            }
        }
        System.out.println("O dado de entrada tem "+cont+" vogais.\n");
        in.close();
    }
}
