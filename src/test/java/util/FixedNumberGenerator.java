package util;

import domain.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {
    private final int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
