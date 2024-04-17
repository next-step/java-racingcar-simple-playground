package racingcar.infrastructure;

import racingcar.domain.NumberGenerator;

public class FakeNotMovableNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return 3;
    }
}
