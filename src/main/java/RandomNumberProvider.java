import java.util.Random;

public class RandomNumberProvider {
    Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(10);
    }
}
