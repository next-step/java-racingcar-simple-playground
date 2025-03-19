package domain;

public class MoveStrategy {

    private final static int MOVE_THRESHOLD = 4;

    public boolean canMove(int num) {
        return num >= MOVE_THRESHOLD;
    }

}
