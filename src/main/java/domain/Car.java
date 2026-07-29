package domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }

        this.name = name;
        this.position = 0;
    }

    void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
