package model.Number;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int genrator()
    {
        final Random random = new Random();
        return random.nextInt(10);
    }
}
