import java.util.Random;

public class RandomNumberGenerator {
    Random random = new Random();

    public int generate() {
        return random.nextInt(10);
    }
}
