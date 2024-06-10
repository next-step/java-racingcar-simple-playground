package domain;

import decider.PositionDecider;

public class Car {

    private final String name;
    private final PositionDecider positionDecider;

    private static final int MOVABLE_BOUND = 4;

    private int position = 0;

    public Car(String name, PositionDecider positionDecider) {
        this.name = name;
        this.positionDecider = positionDecider;
    }

    public void move() {
        if (isMovable(positionDecider.getPosition())) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    private boolean isMovable(int value) {
        return value >= MOVABLE_BOUND;
    }

    public int getPosition() {
        return position;
    }

    public boolean hasWinnerPosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return "domain.Car{" +
            "position=" + position +
            ", name='" + name + '\'' +
            '}';
    }

    public void showStatus() {
        System.out.println(name + ":" + "-".repeat(position));
    }
}
