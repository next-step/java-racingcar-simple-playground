package racingcar.domain;

public class Car {
    private int position = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
