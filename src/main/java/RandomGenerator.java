import java.util.Random;

public class RandomGenerator {
    Random random = new Random();

    public int getRandomValue() {
        return random.nextInt(10);
    }
}
