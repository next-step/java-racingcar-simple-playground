package CarGame2.domain.model;

public class Car {

    private static final int MIN_SPEED = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private int position = 0;
    private int speed;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(int speed) {
        if (speed >= MIN_SPEED) {
            position += speed;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
