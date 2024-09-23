package domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}


