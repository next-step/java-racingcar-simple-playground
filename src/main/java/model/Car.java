package model;

import strategy.MoveStrategy;

public class Car {
    private final Name name;
    private final MoveStrategy moveStrategy;
    private int position;

    public Car(final String name, final MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.moveStrategy = moveStrategy;
        this.position = 0;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        if (moveStrategy.canMove()) {
            position++;
        }
    }
}
