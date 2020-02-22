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
            board.boardPos(pos, player[l].getPlayerNick());

            if(board.isFree(pos)){
                if(board.isBuying(pos)){
                    if(player[l].hasEnoughMoney(board.price(pos))){
                        board.setOwner(pos, player[l].getPlayerNick());
                        player[l].buyingProperty(board.price(pos));
                        player[l].addLocation(board.boardPos(pos));
                    }
                }
            }
            player[l].getPlayerMenu();
            String option = input.next();
            player[l].playerMenu(option);
            l++;
            if (l == player.length) {
                l = 0;
            }
        }
    }

}