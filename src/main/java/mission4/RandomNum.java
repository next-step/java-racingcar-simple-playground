package mission4;

import java.util.Random;

public class RandomNum implements NumberGenerator{
    private final Random random = new Random();
    private final int bound;

    public RandomNum(int bound) {
        this.bound = bound;
    }

    @Override
    public int numberGenerator() {
        return random.nextInt(bound);
    }
}
