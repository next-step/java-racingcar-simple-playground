package domain.car;

import domain.strategy.Movable;
import domain.strategy.RandomMoveStrategy;

public class Car {
    private final String carName;
    private int position;
    private final Movable movable;
    private static final int MAX_LENGTH = 5;

    public static Car createDefaultCar(String name) {
        final int MOVE_THRESHOLD = 4;
        final int RANDOM_BOUND = 10;
        final int INITIAL_POSITION = 0;

        return new Car(name, new RandomMoveStrategy(MOVE_THRESHOLD, RANDOM_BOUND),
            INITIAL_POSITION);
    }

    public Car(String name, Movable movable, int position) {
        validateName(name);
        this.carName = name;
        this.movable = movable;
        this.position = position;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비워둘 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void move() {
        if (movable.canMove()) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
