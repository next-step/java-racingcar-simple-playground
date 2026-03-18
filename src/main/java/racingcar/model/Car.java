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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("비어 있는 이름은 허용되지 않습니다.");
        }
        if (name.length() > 10) {
            throw new IllegalArgumentException("10자를 초과하는 이름은 허용되지 않습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
