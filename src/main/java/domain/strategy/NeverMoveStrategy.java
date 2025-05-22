package domain.strategy;

public class NeverMoveStrategy implements Movable {
    @Override
    public boolean canMove() {
        return false;
    }
}
