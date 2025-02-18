package test;

import model.RandomUtil;

public class FixedNumberGenerator implements RandomUtil {
    private final int fixedNumber;

    public FixedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generateRandomNumber() {
        return fixedNumber;
    }
}
