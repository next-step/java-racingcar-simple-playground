public class Car {

    private static final int MOVABLE_OFFSET = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    public void moveForward(final int inputValue) {
        if (inputValue >= MOVABLE_OFFSET) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }
}
