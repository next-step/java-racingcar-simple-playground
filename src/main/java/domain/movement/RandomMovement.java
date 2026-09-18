package domain.movement;

import java.util.Random;

public class RandomMovement implements CarMovement {
    private static final int RANDOM_BOUND = 10;
    private Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_BOUND);
    }
}
