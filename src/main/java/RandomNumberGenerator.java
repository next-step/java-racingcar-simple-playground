import java.util.Random;

public class RandomNumberGenerator {
    public int createRandomNumber() {
        Random random = new Random();
        int ran = random.nextInt(0, 10);
        return ran;
    }
}
