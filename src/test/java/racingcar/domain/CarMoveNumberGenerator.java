package racingcar.domain;

public class CarMoveNumberGenerator implements MakeNumStrategy {
    public static final int CAR_MOVING_THRESHOLD = 4;

    @Override
    public int makeNum() {
        return CAR_MOVING_THRESHOLD;
    }
}
