package racingcar.domain;

public class Car {

    private static final int START_POSITION = 0;
    private static final int LIMIT_NAME_LENGTH = 5;
    private static final int MOVABLE_OFFSET = 4;
    private static final int FORWARD_AMOUNT = 1;

    private final String name;
    private final int position;

    public Car(final String name, final int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public static Car createDefault(final String name) {
        return new Car(name, START_POSITION);
    }

    private void validateName(final String name) {
        if (name.isEmpty() || name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차의 이름은 반드시 존재해야 하고, 최대 %d글자 이하여야 합니다.", LIMIT_NAME_LENGTH)
            );
        }
    }

    public Car moveForward(final int inputValue) {
        if (inputValue >= MOVABLE_OFFSET) {
            return new Car(getName(), getPosition() + FORWARD_AMOUNT);
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
