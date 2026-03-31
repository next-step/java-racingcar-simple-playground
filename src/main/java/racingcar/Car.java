package racingcar;

public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void addDistance(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}