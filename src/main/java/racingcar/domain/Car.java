package racingcar.domain;

import java.util.Objects;

import racingcar.util.RandomGenerator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 5) {
            throw new RuntimeException("자동차 이름은 5자 이하만 가능하다");
        }
        this.name = name;
    }

    public void move(RandomGenerator random) {
        if (random.generate() >= 4) {
            ++position;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name) && position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
