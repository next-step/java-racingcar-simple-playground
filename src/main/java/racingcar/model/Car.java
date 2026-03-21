package racingcar.model;

public class Car {
    private static final int FORWARD_RULE = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validName(name);
        this.name = name;
        position = 0;
    }

    public void moveForward(NumberGenerator numberGenerator) {
        if (numberGenerator.generateNumber() >= FORWARD_RULE) {
            position++;
        }
    }

    private void validName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상, 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
