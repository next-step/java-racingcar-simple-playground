import java.util.Random;

public class RandomMovement implements CarMovement {
    private Random random = new Random();

    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_CONDITION = 4;

    @Override
    public boolean isMovable() {
        int number = random.nextInt(RANDOM_BOUND);
        return number >= MOVABLE_CONDITION;
    }
}