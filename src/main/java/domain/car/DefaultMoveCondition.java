package domain.car;

public class DefaultMoveCondition implements MoveCondition {
    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean movable(int number) {
        return number >= MOVABLE_NUMBER;
    }
}
