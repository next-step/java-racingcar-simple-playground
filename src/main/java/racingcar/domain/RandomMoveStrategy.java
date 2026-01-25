package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final Random random;
    private static final int RANDOM_BOUND = 10;
    private static final int MIN_VALUE_TO_MOVE = 4;

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean canMove() {
        return random.nextInt(RANDOM_BOUND) >= MIN_VALUE_TO_MOVE;
    }
}
