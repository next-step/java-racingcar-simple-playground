public class Car {
    private static final int MIN_POWER_TO_MOVE = 3;

    private final String name;
    private int position;

    public Car(final String name) {
        validateEmptyName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateEmptyName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    public void moveForward(final int power) {
        if (MIN_POWER_TO_MOVE < power) {
            position++;
        }
    }
}
