package Vencislav;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Table for ");
        Board board = new Board();
        int playerNumber = input.nextInt();
        Player[] player = new Player[playerNumber];
        for (int i = 0; i < player.length; i++) {
            player[i] = new Player();
        }
        for (int i = 0; i < playerNumber; i++) {
            player[i].setPlayerNick(i);
        }
        String playerOption = "";
        int l = 0;

        while (!playerOption.equals("0")) {
            System.out.println(player[l].getPlayerNick());
            playerOption = input.next();
            player[l].playerMovement();
            int pos = player[l].getPosition();
            board.boardPos(pos);

            if (board.isFree(pos)) {
                if (board.isBuying(pos)) {
                    if (player[l].hasEnoughMoney(board.price(pos))) {
                        board.setOwner(pos, player[l].getPlayerNick());
                        player[l].buyingProperty(board.price(pos));
                        player[l].addLocation(board.bPos(pos));
                    }
                }
            }
            if (!board.ownsThePlace(pos, player[l].getPlayerNick())) {
                player[l].beingCharged(board.feeTax(pos));
                for (int i = 0; i < playerNumber; i++) {
                    if(board.ownsThePlace(pos,player[i].getPlayerNick())){
                        player[i].receiveMoney(board.feeTax(pos));
                    }
                }
            }

            player[l].getPlayerMenu();

            player[l].playerMenu();
            l++;
            if (l == player.length) {
                l = 0;
            }
        }
    }

}