public class Car {

    private static final int CRITICAL_NUMBER_TO_MOVE = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= CRITICAL_NUMBER_TO_MOVE) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isSamePosition(int distance) {
        return distance == this.distance;
    }
}
