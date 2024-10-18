import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class App {
    
    public void somatoria(){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> num = new ArrayList<>();
        Iterator<Integer> it = num.iterator();
        int numb, soma=0;
        System.out.println("\nInforme números interios para soma, e digite 0 para finalizar a entrada de dados");
        do{
            System.out.print(" >> ");
            numb=in.nextInt();
            if(numb!=0){
                num.add(numb);
            }
        }while(numb!=0);
        it=num.iterator();
        while (it.hasNext()) {
            soma+=it.next();
        }
        System.out.println("A soma dos números digitados é: "+ soma+"\n");
        in.close();
    }   
    public static void main(String[] args) throws Exception {
        App metodo = new App();
        metodo.somatoria();
    }
}
