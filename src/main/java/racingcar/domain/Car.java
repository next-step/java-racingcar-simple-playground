package racingcar.domain;

public class Car {

    private static final int START_POSITION = 0;
    private static final int LIMIT_NAME_LENGTH = 5;
    private static final int MOVABLE_OFFSET = 4;
    private static final int FORWARD_AMOUNT = 1;

    private final String name;
    private final int position;
    private final NumberGenerator numberGenerator;

    public Car(final String name, final int position, final NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.position = position;
        this.numberGenerator = numberGenerator;
    }

    public Car(final String name, final NumberGenerator numberGenerator) {
        this(name, START_POSITION, numberGenerator);
    }

    private void validateName(final String name) {
        if (name == null || name.isEmpty() || name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차의 이름은 반드시 존재해야 하고, 최대 %d글자 이하여야 합니다.", LIMIT_NAME_LENGTH)
            );
        }
    }

    public Car moveForward() {
        if (numberGenerator.generateNumber() >= MOVABLE_OFFSET) {
            return new Car(name, position + FORWARD_AMOUNT, numberGenerator);
        }
        return this;
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
