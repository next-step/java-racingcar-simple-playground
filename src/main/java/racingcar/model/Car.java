package racingcar.model;

public class Car {
    private final String name;
    private int position;

    private static final int FORWARD_RULE = 4;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(NumberGenerator numberGenerator) {
        if (numberGenerator.generateNumber() >= FORWARD_RULE) {
            position++;
        }
    }
}
