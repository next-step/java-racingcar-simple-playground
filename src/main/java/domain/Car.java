package domain;


public class Car implements Participant {
    private static final int FORWARD_CONDITION = 4;

    private final String name;

    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public void moveForward(int luck) {
        if (luck >= FORWARD_CONDITION) {
            distance += 1;
        }
    }
}
