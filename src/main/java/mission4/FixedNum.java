package mission4;

import java.util.Random;

public class FixedNum implements NumberGenerator{
    Random random = new Random();
    private final int fixedNum;

    public FixedNum(int fixedNum) {
        this.fixedNum = fixedNum;
    }
    @Override
    public int numberGenerator() {
        return fixedNum;
    }
}
