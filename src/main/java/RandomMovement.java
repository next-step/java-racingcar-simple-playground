import java.util.Random;

public class RandomMovement implements CarMovement {
    private Random random = new Random();

    @Override
    public boolean isMovable() {
        int number = random.nextInt(Constants.RANDOM_BOUND);
        return number >= Constants.MOVABLE_CONDITION;
    }
}