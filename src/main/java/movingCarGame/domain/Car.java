package movingCarGame.domain;

public class Car {
    private static final int MIN_MOVE_CONDITION = 4;
    private static final int MOVE_STEP = 1;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomValue) {
        if (randomValue >= MIN_MOVE_CONDITION) {
            addDistance(MOVE_STEP);
        }
    }

    public void addDistance(int addValue) {
        distance += addValue;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

}
