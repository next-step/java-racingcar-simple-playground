package racingcar.domain;

public class CarStopNumberGenerator implements MakeNumStrategy{
    public static final int CAR_STOP_NUMBER_THRESHOLD = 3;

    @Override
    public int makeNum() {
        return CAR_STOP_NUMBER_THRESHOLD;
    }

}
