package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;
    private final Random random;

    public RandomMoveStrategy() {
        this(new Random());
    }

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_RANGE) >= MOVE_THRESHOLD;
    }
}

