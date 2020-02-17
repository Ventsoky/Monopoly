package Vencislav;

import java.util.Random;

public class Monopoly {
    public static Random rand = new Random();
    private static int dice1;
    private static int dice2;
    private static int movement;
    private static int[] gameBoard = {};


    public static void throwDice1(){
        dice1 = rand.nextInt(6)+1;
        //return dice1;
    }
    public static void throwDice2(){
        dice2 = rand.nextInt(6)+1;
        //return dice2;
    }
    public static int playerMovements(){
        return movement = dice1+dice2;
    }

}
