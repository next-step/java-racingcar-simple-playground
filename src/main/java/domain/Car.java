package domain;

public class Car {
    private final String name;
    private int distance = 0;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


    public void move(int n) {
        if (n >= MOVE_THRESHOLD) {
            distance++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }

}
