package domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int THRESHOLD = 4;
    private static final Random random = new Random();

    @Override
    public boolean canMove() {
        return random.nextInt(10) >= THRESHOLD;
    }
}