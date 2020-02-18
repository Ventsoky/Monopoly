package Vencislav;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        Monopoly player = new Monopoly();
        Board board = new Board();
        String playerOption = "";
        while (playerOption.equals("0") == false) {
            playerOption = input.next();
            player.throwDice1();
            player.throwDice2();
            board.writePosition(player.playerPosition());
        }

    }
}