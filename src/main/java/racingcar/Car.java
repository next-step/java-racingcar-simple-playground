package racingcar;

public class Car {

    private static final int MOVE_DISTANCE = 1;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position += MOVE_DISTANCE;
    }
}
