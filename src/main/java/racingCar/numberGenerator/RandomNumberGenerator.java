package racingCar.numberGenerator;

import java.util.Random;

import racingCar.numberGenerator.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    Random random = new Random();

    public int generate() {
        return random.nextInt(10);
    }
}
