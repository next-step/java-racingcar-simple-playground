package domain;

public class Car {
    private final CarName name;

    private int location;

    public Car(CarName name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        this.location++;
    }

    public CarName getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}


