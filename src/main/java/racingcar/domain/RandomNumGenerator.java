package racingcar.domain;

import java.util.Random;

public class RandomNumGenerator implements MakeNumStrategy {
    @Override
    public int makeNum() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
