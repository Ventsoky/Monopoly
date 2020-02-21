package Vencislav;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Table for ");
        int playerNumber = input.nextInt();
        Player[] player = new Player[playerNumber];
        for (int i = 0; i < player.length; i++) {
            player[i] = new Player();
        }
        for (int i = 0; i < playerNumber; i++) {
            player[i].setPlayerNick(i);

        }
        for (int i = 0; i < playerNumber; i++) {
            System.out.println(player[i].getPlayerNick());

        }
        Board board = new Board();
        String playerOption = "";
        int l = 0;
        while (!playerOption.equals("0")) {
            System.out.println(player[l].getPlayerNick());
            playerOption = input.next();
            player[l].playerMovement();
            board.boardPos(player[l].getPossition(), player[l].getPlayerNick());
            if(board.isFree(player[l].getPossition())){
                if(board.isBuying()){
                    board.setOwner(player[l].getPossition(), player[l].getPlayerNick());
                    player[l].addLocation(board.boardPos(player[l].getPossition()));
                }
            }

            player[l].writeBelongings();

            l++;
            if (l == player.length) {
                l = 0;
            }
        }
        System.out.println(board.quickCheck());

    }

}