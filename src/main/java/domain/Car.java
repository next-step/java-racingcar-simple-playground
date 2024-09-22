package domain;

import java.util.Objects;

public class Car {
    public final String name;

    public int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        this.location++;
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


