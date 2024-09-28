package domain.car;

import domain.racegame.MoveStrategy;

public class NeverMoveStrategy implements MoveStrategy {

    @Override
    public boolean canMove(int number) {
        return false;
    }
}
