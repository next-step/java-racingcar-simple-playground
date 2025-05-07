package strategy;

public class AlwaysTrueMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}
