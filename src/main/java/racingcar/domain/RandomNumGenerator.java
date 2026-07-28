package racingcar.domain;

import java.util.Random;

public class RandomNumGenerator implements MakeNumStrategy {
    public static final int MOVE_CAR_ARGUMENT_RANGE = 10;

    @Override
    public int makeNum() {
        Random random = new Random();
        return random.nextInt(MOVE_CAR_ARGUMENT_RANGE);
    }
}
