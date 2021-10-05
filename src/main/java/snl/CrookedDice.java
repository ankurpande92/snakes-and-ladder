package snl;

import java.util.Random;

public class CrookedDice extends Dice {
    public CrookedDice() {
    }

    public CrookedDice(Random random) {
        super(random);
    }

    @Override
    public int roll() {
        int diceNumber = getRandom().nextInt(7);
        return diceNumber == 0 ? 2 : (diceNumber % 2 == 0 ? diceNumber : 2);
    }
}
