package racingcar;

public class Car {

    private static final int ACCELERATION = 4;

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
    }

    public void move(RandomNumberGenerator generator) {
        if (generator.generate() >= ACCELERATION) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
