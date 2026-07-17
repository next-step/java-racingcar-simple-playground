package domain;

public class NumberMovingStrategy implements MovingStrategy {
    private static final int MOVABLE_THRESHOLD = 4;

    @Override
    public boolean isMovable(int number) {
        return number >= MOVABLE_THRESHOLD;
    }
}
