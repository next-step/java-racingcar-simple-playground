package racinggame.model.car.policy.numbergenerator;
import java.util.Random;

public class ZeroToNineRandomGenerator implements RandomGenerator {
    private final Random random=new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
