package racingcar.infrastructure;

import racingcar.domain.NumberGenerator;

public class FakeMovableNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return 4;
    }
}
