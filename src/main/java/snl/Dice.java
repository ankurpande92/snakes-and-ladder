package snl;

import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        random = new Random();
    }

    public Dice(Random random) {
        this.random = random;
    }

    public Random getRandom() {
        return random;
    }

    public int roll() {
        int diceNumber = random.nextInt(7);
        return diceNumber == 0 ? 1 : diceNumber;
    }
}
