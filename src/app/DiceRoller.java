package app;

import java.util.Random;

class DiceRoller {
    private static final Random random = new Random();

    public static int rollDice() {
        return random.nextInt(11) + 2;
    }
}