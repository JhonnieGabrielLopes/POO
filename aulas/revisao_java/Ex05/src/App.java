public class App {

    public void printnumero(int[] numero){
        for (int i : numero) {
            System.out.print(i+"; ");
        }
        System.out.println("\n");
    }
    public void ordenador(int[] numero){
        int tam = numero.length;
        int var;
        boolean controle;

        for(int i=0;i<tam-1; i++){
            controle=false;
            for (int j=0;j<tam-i-1; j++) {
                if (numero[j]>numero[j+1]) {
                    var=numero[j];
                    numero[j]=numero[j+1];
                    numero[j+1]=var;
                    controle=true;
                }
            }
            if (!controle) {
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        int[] numero = {10,20,5,40,9,80,70,30,-20,-15};
        App metodo = new App();
        System.out.println("\nSistema de ordenação de números");
        System.out.print("desordenado: ");
        metodo.printnumero(numero);
        metodo.ordenador(numero);
        System.out.print("ordenado: ");
        metodo.printnumero(numero);
    }
}
