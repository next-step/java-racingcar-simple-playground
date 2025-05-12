package domain;

public class MoveConditionImpl implements MoveCondition{
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable(int value) {
        return value >= MOVE_THRESHOLD;
    }
}
