package racingcar.domain;

import java.util.Random;

public final class RandomNumGenerator {
    public static final int MOVE_CAR_ARGUMENT_RANGE = 10;

    private RandomNumGenerator(){

    }

    public static int makeNum() {
        Random random = new Random();
        return random.nextInt(MOVE_CAR_ARGUMENT_RANGE);
    }
}
