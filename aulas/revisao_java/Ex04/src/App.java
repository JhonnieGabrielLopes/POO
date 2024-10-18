import java.util.Scanner;

public class App {

    public int verifrase(){
        Scanner in = new Scanner(System.in);
        String entrada;
        System.out.println("\nDigite uma frase");
        entrada=in.nextLine();
        String[] palavras = entrada.split(" ");
        in.close();
        return palavras.length;
    }
    public static void main(String[] args) throws Exception {
        App metodo = new App();
        int numero;
        numero = metodo.verifrase();
        System.out.println("\nA frase tem "+numero+" palavras!\n");
    }
}
