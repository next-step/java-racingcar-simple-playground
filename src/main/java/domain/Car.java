package domain;

public class Car {

    private static final int MOVABLE_NUMBER = 4;

    private final String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= MOVABLE_NUMBER) {
            location++;
        }
    }
}
