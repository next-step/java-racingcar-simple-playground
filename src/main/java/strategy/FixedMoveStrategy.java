package strategy;

public class FixedMoveStrategy implements MoveStrategy {

    private final boolean fixedValue;

    public FixedMoveStrategy(boolean fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public boolean isMovable() {
        return fixedValue;
    }
}
