package fixed;

import domain.rand.Move;

public class FalseFixedMove extends Move {

    public FalseFixedMove(int min, int max, int threshold) {
        super(min, max, threshold);
    }

    @Override
    public int getRandValue() {
        return super.getThreshold() - 1;
    }
}
