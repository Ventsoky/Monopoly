package Vencislav;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Monopoly player = new Monopoly();
        for (int i = 0; i < 8; i++) {
            player.throwDice1();
            player.throwDice2();
            System.out.println(player.playerMovements());

        }
        
    }
}
