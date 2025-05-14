import java.util.Random;

public class RandomNumberProvider {
    private static final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(10);
    }
}
