package domain;

public class Car {
    private static final int MOVE_CRITERION = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다."
            );
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_CRITERION) {
            position++;
        }
    }
}
