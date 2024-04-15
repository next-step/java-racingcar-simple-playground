import java.util.Random;

public class RandomNumberGenerator {
    public int generate(){
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }
}
