package domain.car;

public class Car {
    private final String name;
    private int position;

    private static final int FORWARD_RULE = 4;
    private static final int MIN_MOVING_NUMBER = 0;
    private static final int MAX_MOVING_NUMBER = 9;
    private static final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        validateMoveNumber(number);

        if (number >= FORWARD_RULE) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자 이하만 가능합니다.");
        }
    }

    private void validateMoveNumber(int number) {
        if (number > MAX_MOVING_NUMBER || number < MIN_MOVING_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 숫자값입니다.");
        }
    }
}
