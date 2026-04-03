public class Car {
    private static final int MAX_POSITION = 4;
    private final String name;
    private int position;

    public Car(final String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(final NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MAX_POSITION) {
            this.position++;
        }
    }

    public boolean isSamePosition(final Car otherCar) {
        return this.position == otherCar.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}