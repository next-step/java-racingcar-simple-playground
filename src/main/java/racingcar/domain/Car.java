package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAXIMUM_CAR_NAME_LENGTH + "자 이하만 가능합니다.");
        }
    }

}
