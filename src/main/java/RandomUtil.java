import java.util.Random;

public class RandomUtil {
    private static final int RANDOM_LIMIT = 10;
    private static final Random random = new Random();

    public static int randomGenerator(){
        //0 <= value <= 9
        return random.nextInt(10);
    }
}
