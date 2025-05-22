package domain.strategy;

public class AlwaysMoveStrategy implements Movable {
    @Override
    public boolean canMove() {
        return true;
    }
}
