package domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (canMove(randomNumber)) {
            position++;
        }
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    public boolean isSamePosition(int targetPosition) {
        return position == targetPosition;
    }

    Car copy() {
        return new Car(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}