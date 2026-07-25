import domain.NumberGenerator;

import java.util.Random;

public class TestNumberGenerator implements NumberGenerator {
    Random random;

    public TestNumberGenerator(int seedNum) {
        this.random = new Random(seedNum);
    }

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
