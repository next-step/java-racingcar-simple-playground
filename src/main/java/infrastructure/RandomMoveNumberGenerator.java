package infrastructure;

import java.util.Random;

import domain.MoveNumberGenerator;

public class RandomMoveNumberGenerator implements MoveNumberGenerator {
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
