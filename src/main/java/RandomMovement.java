import java.util.Random;

public class RandomMovement implements CarMovement {
    private Random random = new Random();

    @Override
    public boolean isMovable() {
        int number = random.nextInt(10);
        return number >= 4;
    }
}