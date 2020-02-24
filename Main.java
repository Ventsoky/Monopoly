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
            if(player[l].isInPrison()){
                if(player[l].usesPrisonPass()){
                    player[l].getOutOfPrison();
                }
                player[l].getOutOfPrison();
                nextPlayer(l,playerNumber);
                continue;
            }
            System.out.println(player[l].getPlayerNick());
            playerOption = input.next();
            player[l].playerMovement();
            int pos = player[l].getPosition();
            board.boardPos(pos);
            if (board.getsInJail(pos)){
                System.out.println("You are now in prison for your bad crimes.");
                player[l].getInPrison();
                nextPlayer(l,playerNumber);
                continue;
            }
            else if (board.isFree(pos)) {
                if (board.isBuying(pos)) {
                    if (player[l].hasEnoughMoney(board.placePrize(pos))) {
                        board.setOwner(pos, player[l].getPlayerNick());
                        player[l].buyingProperty(board.placePrize(pos));
                        player[l].addLocation(board.bPos(pos));
                    }
                }
            }
            else if (!board.ownsThePlace(pos, player[l].getPlayerNick())) {
                player[l].beingCharged(board.feeTax(pos));
                for (int i = 0; i < playerNumber; i++) {
                    if(board.ownsThePlace(pos,player[i].getPlayerNick())){
                        player[i].receiveMoney(board.feeTax(pos));
                    }
                }
            }

            player[l].getPlayerMenu();

            player[l].playerMenu();
            nextPlayer(l,playerNumber);
        }
    }

    private static void nextPlayer(int l, int length) {
        l++;
        if (l == length) {
            l = 0;
        }
    }

}