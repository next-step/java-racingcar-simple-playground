import java.util.Random;

public class RandInt implements IClass {

    private final Random random = new Random();

    @Override
    public int giveInt() {
        return random.nextInt(10);
    }
}
