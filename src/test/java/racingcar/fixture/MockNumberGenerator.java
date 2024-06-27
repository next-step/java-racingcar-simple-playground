package racingcar.fixture;

import racingcar.RandomNumberGenerator;

public class MockNumberGenerator {

    public static class Number1Generator implements RandomNumberGenerator {

        @Override
        public int generate() {
            return 1;
        }
    }

    public static class Number4Generator implements RandomNumberGenerator {

        @Override
        public int generate() {
            return 4;
        }
    }
}
