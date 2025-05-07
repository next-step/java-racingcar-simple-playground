package strategy;

public class AlwaysFalseMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return false;
    }
}
