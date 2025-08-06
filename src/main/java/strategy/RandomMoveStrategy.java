package strategy;

import util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        int randomValue = RandomUtil.getRandomValue(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
        return randomValue >= MOVE_THRESHOLD;
    }
}
