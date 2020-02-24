package Vencislav;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private Scanner input = new Scanner(System.in);
    private Random rand = new Random();
    private int dice1 = 1;
    private int dice2 = 4;
    private int position;
    private String playerNick;
    private int money = 1500;
    private List belongings = new ArrayList();


    private int throwDice1() {
        dice1 = rand.nextInt(6) + 1;
        return dice1;

    }

    private int throwDice2() {
        dice2 = rand.nextInt(6) + 1;
        return dice2;

    }

    public int getPosition() {
        return position;

    }

    public void playerMovement() {

//        throwDice1();
//        throwDice2();
        if (position + dice1 + dice2 > 38) {
            position = (dice1 + dice2) - Math.abs(position - 38) - 1;
            money += 200;
        } else position = position + dice1 + dice2;
        System.out.println("You threw " + dice1 + " and " + dice2 + ". So you move " + (dice1 + dice2));
    }

    public void setPlayerNick(int i) {
        System.out.println("Player " + (i + 1) + " nick is:");
        playerNick = input.nextLine();
    }

    public String getPlayerNick() {
        return playerNick;
    }

    public void addLocation(String newBelonging) {
        belongings.add(newBelonging);
    }

    public void writeBelongings() {
        for (int i = 0; i < belongings.size(); i++) {
            System.out.println(i + 1 + ". " + belongings.get(i));
        }
    }

    public void sellProp(int i) {
        belongings.remove(i);
    }

    public int getMoney() {
        return money;
    }

    public void buyingProperty(int price) {
        money -= price;
    }

    public boolean hasEnoughMoney(int price) {
        if (money - price >= 0)
            return true;
        System.out.println("Not enough money!");
        return false;
    }

    public void getPlayerMenu() {
        System.out.println("Type \"money\" to see how much money you have.");
        System.out.println("Type \"props\" to see the places you own");
        System.out.println("Type \"end\" to end your turn");
    }

    public void playerMenu() {
        String option = input.next();
        switch (option) {
            case "money":
                System.out.println(money);
                playerMenu();
                break;
            case "props":
                writeBelongings();
                playerMenu();
            case "end":
                break;
            default:
                System.out.println("Wrong input. Try again!");
                playerMenu();
        }
    }

    public void beingCharged(int fee) {
        money -= fee;
    }
    public void receiveMoney(int receive){
        money += receive;
    }

}
