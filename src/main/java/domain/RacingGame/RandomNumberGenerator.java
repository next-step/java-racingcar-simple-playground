package domain.RacingGame;

import java.util.Random;
import util.Constants;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(Constants.UPPER_BOUND_OF_RANDOM_NUMBER);
    }
}
