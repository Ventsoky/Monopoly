package Vencislav;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int playerNumber = input.nextInt();
        Player[] player = new Player[playerNumber];
        for (int i = 0; i < player.length; i++) {
            player[i] = new Player();
        }
        Board board = new Board();
        String playerOption = "";
        int playerIndex = 0;
        while (!playerOption.equals("0")) {
            System.out.println("Player" + (playerIndex + 1));
            playerOption = input.next();
            player[playerIndex].throwDice1();
            player[playerIndex].throwDice2();
            player[playerIndex].playerMovement();
            board.writePosition(player[playerIndex].playerPosition());
            playerIndex++;
            if (playerIndex == player.length) {
                playerIndex = 0;
            }
        }

    }
}