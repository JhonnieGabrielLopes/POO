import java.util.Scanner;

public class Informacoes {
    
    public void comoJogar(Scanner in){        //como jogar e comandos
        System.out.println("COMO JOGAR");
        System.out.println("A partida é dividida em rodadas, cada jogador terá a sua vez de atacar. Basicamente vence aquele que zerar a energia do seu adverário.");
        System.out.println("Durante a partida, você terá duas opções: Atacar e verificar o status, você poderá ver o status antes de cada ataque");
        System.out.println("Os ataques são classificados em:");
        System.out.println("  > COMUM - Causa 10% de dano com base na vida inicial do jogador");
        System.out.println("  > REDUZIDO - Causa 4% de dano com base na vida inicial do jogador. Situação em que o adversário tentou uma defesa.");
        System.out.println("  > CRÍTICO - Causa 20% de dano com base na vida inicial do jogador. Situação em que o adversário desfere um golpe mais danoso.");
        System.out.println("Todo jogador tem energia e pontuação, a medida que você faz um ataque, sua pontuação aumenta e o adversário perde energia!");
        System.out.println("A pontuação é dada de acordo com o tipo de dano infrigido ao adversário, sendo as seguintes pontuações:");
        System.out.println("  > COMUM - 28pts\n  > REDUZIDO - 15pts\n  > CRÍTICO - 50pts");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("COMANDOS \n  > /attack ou /A - Causa dano ao adversário. Classificado em comum, reduzido e crítico.");
        System.out.println("  > /status ou /S - exibe nome, sua energia e sua pontuação!");
        System.out.println("  > /exit - encerra a partida por abandono do jogador, e é dada a vitória ao adversário!");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.print(" > ENTER...");
        in.nextLine();
        Limpar_terminal.limpar();
    }

    public void menu(Jogador player01){         //menu de opções
        int i=3;
        System.out.println("Menu de opções");
        System.out.println(" > [1].Inserir nome");
        if(player01.getNome()!=null){
        System.out.println(" > ["+(i-1)+"].Iniciar jogo");
        i++;}
        System.out.println(" > ["+(i-1)+"].Como jogar");
        System.out.println(" > ["+(i)+"].Sair");
        System.out.println("-------------------------");
    }
}
