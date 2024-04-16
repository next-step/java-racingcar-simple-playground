package racingcar.infrastructure;

import racingcar.domain.NumberGenerator;

public class RandomNumberFakeGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return 4;
    }
}