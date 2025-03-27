package domain;

public class Car {

    private static final int MOVE_DISTANCE = 1;
    public static final int MAX_CAR_NAME_SIZE = 5;

    private final String name;
    private int distance;

    private Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public static Car createCar(String name) {
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException("차량의 이름은 " + MAX_CAR_NAME_SIZE + "자 이하여야 합니다.");
        }
        if (name.trim().isBlank()) {
            throw new IllegalArgumentException("차량 이름을 입력해야 합니다.");
        }
        return new Car(name);
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
