package domain.rand;

public abstract class Move {

    private final int threshold;
    private final int min;
    private final int max;

    public Move(int min, int max, int threshold) {
        this.min = min;
        this.max = max;
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public boolean isMovable(int value) {
        return value >= threshold;
    }

    public abstract int getRandValue();
}
