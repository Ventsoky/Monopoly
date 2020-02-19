package Vencislav;

import java.util.Random;

public class Player {
    private Random rand = new Random();
    private int dice1;
    private int dice2;
    private int position;

    public int throwDice1() {
        dice1 = rand.nextInt(6) + 1;
        return dice1;

    }

    public int throwDice2() {
        dice2 = rand.nextInt(6) + 1;
        return dice2;

    }

    public int playerPosition() {
        if (position + dice1 + dice2 > 38) {
            position = (dice1 + dice2) - Math.abs(position - 38) - 1;
        } else position += dice1 + dice2;
        return position;

    }

    public void playerMovement() {
        System.out.println(dice1 + dice2);
    }

}
