package domain.racegame;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove(int number) {
        return number >= MOVE_THRESHOLD;
    }
}
