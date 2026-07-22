package domain.rand;

import java.util.Random;

public class RandomMove extends Move {

    private final Random rand;

    public RandomMove(int min, int max, int threshold) {
        super(min, max, threshold);
        this.rand = new Random();
    }

    @Override
    public int getRandValue() {
        return super.getMin() + rand.nextInt(super.getMax() + 1);
    }
}
