package racingcar.domain;

public class FixedNumberGenerator implements MakeNumStrategy {
    @Override
    public int makeNum() {
        return 4;
    }
}
