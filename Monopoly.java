package Vencislav;

import java.util.Random;

public class Monopoly {
    private Random rand = new Random();
    private int dice1;
    private int dice2;
    private int position;

    public void throwDice1() {
        dice1 = rand.nextInt(6) + 1;
        System.out.println(dice1);

    }

    public void throwDice2() {
        dice2 = rand.nextInt(6) + 1;
        System.out.println(dice2);

    }

    public int playerPosition() {
        if (position + dice1 + dice2 > 38) {
            position = (dice1 + dice2) - Math.abs(position - 38) - 1;
            return position;
        } else position += dice1 + dice2;
        return position;

    }

}
