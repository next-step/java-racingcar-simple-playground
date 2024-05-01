package org.duckstudy.model.car;

import org.duckstudy.model.strategy.MovableStrategy;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final int position;
    private final MovableStrategy movableStrategy;

    public Car(String name, MovableStrategy movableStrategy) {
        validateCarName(name);

        this.name = name;
        this.position = INITIAL_POSITION;
        this.movableStrategy = movableStrategy;
    }

    public Car(String name, int position, MovableStrategy movableStrategy) {
        validateCarName(name);

        this.name = name;
        this.position = position;
        this.movableStrategy = movableStrategy;
    }

    private void validateCarName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 1글자 이상 %d글자 이하만 가능합니다.\n", MAX_NAME_LENGTH));
        }
    }

    public Car move() {
        if (movableStrategy.isMovable()) {
            return new Car(name, position + 1, movableStrategy);
        }
        return this;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
