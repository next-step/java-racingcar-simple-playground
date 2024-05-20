package model;

import model.MoveStrategy;

public class AlwaysNotMoveStrategy implements MoveStrategy {

    @Override
    public int getNumber() {
        return 3;
    }
}
