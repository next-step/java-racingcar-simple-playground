package decider;

import java.util.Random;

public class RandomPositionDecider implements PositionDecider {

    @Override
    public int generate() {
        final Random random = new Random();
        int MAX = 10;
        return random.nextInt(MAX);
    }
}
