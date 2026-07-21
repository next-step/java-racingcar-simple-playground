import java.util.Random;

public class MakeRandomNum {
    public static int setNum() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
