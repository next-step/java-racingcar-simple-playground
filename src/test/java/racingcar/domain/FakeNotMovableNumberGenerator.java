package racingcar.domain;

public class FakeNotMovableNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return 3;
    }
}
