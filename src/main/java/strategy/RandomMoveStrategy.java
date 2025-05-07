package strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MAX_RANDOM_BELOW = 10;
    private static final int POWER_THRESHOLD_TO_MOVE = 3;

    private final Random random = new Random();

    @Override
    public boolean canMove() {
        return POWER_THRESHOLD_TO_MOVE < getRandomValue();
    }

    private int getRandomValue() {
        return random.nextInt(MAX_RANDOM_BELOW);
    }
}
