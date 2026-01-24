package car.domain.strategy;

import car.domain.strategy.MovingStrategy;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int THRESHOLD = 4;

    @Override
    public boolean canMove() {
        return ThreadLocalRandom.current().nextInt(10) >= THRESHOLD;
    }
}
