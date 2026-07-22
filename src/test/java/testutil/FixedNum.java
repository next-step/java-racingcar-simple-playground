package testutil;

import mission4.NumberGenerator;

public class FixedNum implements NumberGenerator {
    private final int fixedNum;

    public FixedNum(int fixedNum) {
        this.fixedNum = fixedNum;
    }
    @Override
    public int numberGenerator() {
        return fixedNum;
    }
}
