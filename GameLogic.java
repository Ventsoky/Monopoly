package Vencislav;

import java.util.Scanner;

public class GameLogic {
    private Scanner input = new Scanner(System.in);
    private int playerNumber;
    private Player[] player = new Player[playerNumber];
    private Board board = new Board();
    private int l;
    private int pos;


    public void gameSetUp(){
        System.out.println("Table for ");
        playerNumber = input.nextInt();
        player = new Player[playerNumber];
        for (int i = 0; i < player.length; i++) {
            player[i] = new Player();
        }
        for (int i = 0; i < playerNumber; i++) {
            player[i].setPlayerNick(i);
        }
    }

    public void menu() {
        System.out.println("Type \"menu\" to open the list of menus");
        String chooseMenu = input.next();
        switch (chooseMenu) {
            case "menu":
                menuOptions();
                menus();
            default:
                break;
        }
    }

    public void menu2(){
        String chooseOption = input.next();
        switch (chooseOption) {
            case "sell":
                sell();
               menu2();
                break;
            case "trade":
                trade();
                menu2();

                break;
            default:
                break;
        }
    }

    private void trade() {
        System.out.println("Choose a player you want to trade with");
        for (int i = 0; i < player.length; i++) {
            System.out.println(i + 1 + ": " + player[i].getPlayerNick());
        }
        int playerIndexTrade = input.nextInt() - 1;
        if (playerIndexTrade > 0 || playerIndexTrade < player.length) {
            System.out.println("Money you'd like to give");
            int money = input.nextInt();
            if (player[l].hasEnoughMoney(money)) {
                System.out.println("Place you want to give");
                player[l].writeBelongings();
                System.out.println("Type 0 if you don't to trade any of your places.");
                int placeToGive = input.nextInt();
                System.out.println("Money you'd like to receive: ");
                int moneyToReceive = input.nextInt();
                System.out.println("Place you want from the player: ");
                player[playerIndexTrade].writeBelongings();
                System.out.println("Type 0 if you don't want any place to receive.");
                int placeToReceive = input.nextInt();
                if (player[playerIndexTrade].hasEnoughMoney(moneyToReceive)) {
                    theTradingOverviel(money, placeToGive, placeToReceive, moneyToReceive, l, playerIndexTrade, player);
                }
                if (player[playerIndexTrade].acceptsTrade()) {
                    player[l].receiveMoney(moneyToReceive - money);
                    player[playerIndexTrade].receiveMoney(money - moneyToReceive);

                    if (placeToGive > 0) {
                        board.setNewOwner(player[playerIndexTrade].getPlayerNick(), player[l].getCertainBelong(placeToGive - 1));
                        player[playerIndexTrade].addLocation(player[l].getCertainBelong(placeToGive - 1));
                    }

                    if (placeToReceive > 0) {
                        board.setNewOwner(player[l].getPlayerNick(), player[playerIndexTrade].getCertainBelong(placeToReceive - 1));
                        player[l].addLocation(player[playerIndexTrade].getCertainBelong(placeToReceive - 1));
                    }
                    if (placeToGive > 0)
                        player[l].removeProp(placeToGive);
                    if (placeToReceive > 0)
                        player[playerIndexTrade].removeProp(placeToReceive);
                    System.out.println("Trade accepted.");
                }
            }
        }else System.out.println("Not such player");


    }

    private void sell() {
        player[l].writeBelongings();
        int choice = player[l].chooseProp();
        if (player[l].isSellingProp()) {
            System.out.println("You sold your property: " + player[l].getCertainBelong(choice - 1));
            player[l].receiveMoney(board.getSellPrize(player[l].getPropToSell(choice)));
            board.removeOwner(player[l].getPropToSell(choice));
            player[l].removeProp(choice);
        }
    }

    public void menus() {
        String chooseMenu = input.next();
        switch (chooseMenu) {
            case "menu1":
            case "1":
                player[l].getPlayerMenu();
                player[l].playerMenu();
                menus();
                break;
            case "menu2":
            case "2":
                menu2Options();
                menu2();
                menus();
                break;
            default:
                break;
        }
    }

    public void charging() {
        if (!board.ownsThePlace(pos, player[l].getPlayerNick())) {
            player[l].loseMoney(board.feeTax(pos));
            System.out.println("You've been charged with " + board.feeTax(pos) + " leva.");
            for (int i = 0; i < playerNumber; i++) {
                if (board.ownsThePlace(pos, player[i].getPlayerNick())) {
                    System.out.println("And player " + player[i].getPlayerNick() + " took them.");
                    player[i].receiveMoney(board.feeTax(pos));
                }
            }
        }
    }

    public void chanceOrCommunityChest() {
        if (board.isChancePos(pos)) {
            player[l].drawCard();
        }
    }

    public void normalPlace() {
        if (board.isFree(pos)) {
            board.isBuying(pos);
            if (board.getIsBuying()) {
                if (player[l].hasEnoughMoney(board.placePrize(pos))) {
                    board.setOwner(pos, player[l].getPlayerNick());
                    player[l].buyingProperty(board.placePrize(pos));
                    player[l].addLocation(board.bPos(pos));
                }
            }
        }
    }

    public boolean jailBlock() {
        if (board.getsInJail(pos)) {
            System.out.println("You are now in prison for your bad crimes.");
            player[l].getInPrison();
            nextPlayer();
            return true;
        }
        return false;
    }

    public void playerSetUp() {
        System.out.println(player[l].getPlayerNick() + ", it's your turn. Throw the dices");
        player[l].playerMovement();
        pos = player[l].getPosition();
        board.boardPos(pos);
    }

    public boolean prison() {
        if (player[l].isInPrison()) {
            if (player[l].usesPrisonPass()) {
                player[l].getOutOfPrison();
                return false;
            } else {
                player[l].getOutOfPrison();
                nextPlayer();
                return true;
            }
        }
        return false;
    }

    public static void theTradingOverviel(int moneyToGive, int placeToGive, int placeToReceive, int moneyToReceive, int l, int playerIndexTrade, Player[] player) {
        System.out.println(player[playerIndexTrade].getPlayerNick());
        System.out.println("You've been offered:");
        if (moneyToGive > 0)
            System.out.println(moneyToGive + " leva.");
        if (placeToGive > 0)
            System.out.println("Place: " + player[l].getCertainBelong(placeToGive - 1));
        System.out.println("For: ");
        if (moneyToReceive > 0)
            System.out.println(moneyToReceive + " leva.");
        if (placeToReceive > 0)
            System.out.println(player[playerIndexTrade].getCertainBelong(placeToReceive - 1));
    }

    public void nextPlayer() {
        l++;
        if (l >= player.length) {
            l = 0;
        }
    }

    public static void menuOptions() {
        System.out.println("Menu 1: Check your money/props - just type \"menu1\"");
        System.out.println("Menu 2: Check your selling/trading - just type \"menu2\"");
        System.out.println("To end your turn type \"end\"");
    }

    public static void menu2Options() {
        System.out.println("Type \"sell\" to sell property");
        System.out.println("Type \"trade\" to trade with player");
        System.out.println("Type \"close\" to close this menu");
    }
    public void playerOut(){
        if(player[l].isOutOfMoney()){
            if(player[l].getPropsSize()<1){
                System.out.println(player[l].getPlayerNick()+", you lost!");
                removePlayer();
            }
            else {
                sell();
                playerOut();
            }
        }
    }

    private void removePlayer() {
        Player[] resize = new Player[playerNumber-1];
        int j = 0;
        for (int i = 0; i < resize.length; i++) {
            if(i!=l){
                resize[j] = player[i];
                j++;
            }
        }
        playerNumber--;
        player = new Player[playerNumber];
        player = resize;
    }
    public boolean isGameOver(){
        if(player.length==1){
            System.out.println(player[0].getPlayerNick()+", won the game!");
            return true;
        }
        return false;
    }

}
