package domain.car;

import domain.racegame.MoveStrategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove(int number) {
        return true;
    }
}
