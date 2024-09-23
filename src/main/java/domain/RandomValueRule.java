package domain;

import java.util.Random;

public class RandomValueRule implements Rule {
    private final Random rd;

    public RandomValueRule() {
        rd = new Random();
    }

    public boolean canGo() {
        return rd.nextInt(10) >= 4;
    }
}
