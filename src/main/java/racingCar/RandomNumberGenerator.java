package racingCar;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    Random random = new Random();

    public int generate() {
        return random.nextInt(10);
    }
}
