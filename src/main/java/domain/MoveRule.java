package domain;

public class MoveRule {
    private static final int MINIMUM_MOVE_NUMBER = 4;

    public static boolean canMove(int number) {
        return number >= MINIMUM_MOVE_NUMBER;
    }
}
