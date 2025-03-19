package domain;

public class Car {

    private static final int MOVE_DISTANCE = 1;

    private final String name;
    private int distance;

    public Car(String name) {
        CarValidator.validateName(name);
        this.name = name;
        distance = 0;
    }

    public Car(Car car) {
        this.name = car.getName();
        this.distance = car.getDistance();
    }

    void move() {
        distance += MOVE_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
