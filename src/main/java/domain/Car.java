package domain;

public class Car {

    private static final int MOVABLE_MIN = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int num) {
        if (isMovable(num)) {
            position++;
        }
    }

    private boolean isMovable(int num) {
        return num >= MOVABLE_MIN;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private static void validateName(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

}
