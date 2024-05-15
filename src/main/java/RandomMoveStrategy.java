import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    @Override
    public int getNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
