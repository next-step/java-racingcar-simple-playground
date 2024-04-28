package racingcar.domain;

public class FakeMovableNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return 4;
    }
}
