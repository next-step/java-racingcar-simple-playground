public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    void move() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
