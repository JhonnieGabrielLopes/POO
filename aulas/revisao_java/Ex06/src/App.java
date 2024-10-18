public class App {
    public static void main(String[] args) throws Exception {
        int[][] matriz = {{1,7,5},{12,4,6},{0,25,10}};
        int maior=0;

        for (int i=0;i<3;i++) {
            for (int j=0;j<3-1;j++) {
                if (maior<matriz[i][j]) {
                    maior=matriz[i][j];
                }
            }
        }
        System.out.println("\nmaior valor da matriz: "+maior+"\n");
    }
}
