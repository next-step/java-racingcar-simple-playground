package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final Random random = new Random();
    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_RANGE) >= MOVE_THRESHOLD;
    }
}