import java.util.Random;

public class MoveCar {
    private static final int MOVE_THRESHOLD = 4;
    private final Random random;

    public MoveCar(Random random) {
        this.random = random;
    }

    public void tryMove(Car car) {
        int randomNumber = generateRandomNumber();

        if (shouldMove(randomNumber)) {
            car.moveForward();
        }
    }

    public int generateRandomNumber() {
        return this.random.nextInt(10);
    }

    private boolean shouldMove(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

}
