package model.Number;

public class FixedNumberGenerator implements NumberGenerator {
    private static final int NOT_MOVE_CONITION = 1;

    @Override
    public int genrator() {
        return NOT_MOVE_CONITION;
    }
}
