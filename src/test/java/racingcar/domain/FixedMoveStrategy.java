package racingcar.domain;

public class FixedMoveStrategy implements MoveStrategy {

    private final boolean result;

    public FixedMoveStrategy(boolean result) {
        this.result = result;
    }

    @Override
    public boolean canMove() {
        return result;
    }
}
