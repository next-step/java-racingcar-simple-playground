package global;

import java.util.random.RandomGenerator;

public class TestNumberGenerator implements RandomUtil {
    private final int testNumber;

    public TestNumberGenerator(int testNumber) {
        this.testNumber = testNumber;
    }

    @Override
    public int generateRandomNumber() {
        return testNumber;
    }
}
