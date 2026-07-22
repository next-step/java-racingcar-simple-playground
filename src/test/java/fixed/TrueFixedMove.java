package fixed;

import domain.rand.Move;

public class TrueFixedMove extends Move {

    public TrueFixedMove(int min, int max, int threshold) {
        super(min, max, threshold);
    }

    @Override
    public int getRandValue() {
        return super.getThreshold();
    }
}
