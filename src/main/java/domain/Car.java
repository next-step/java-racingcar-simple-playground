package domain;

public class Car {

    private final NumberGenerateStrategy strategy;
    private final String name;
    private int position;

    public Car(final NumberGenerateStrategy strategy,
               final String name) {
        this(strategy, name, 0);
    }

    public Car(final NumberGenerateStrategy strategy,
               final String name,
               final int position) {
        validateName(name);
        this.strategy = strategy;
        this.name = name;
        this.position = position;
    }

    private void validateName(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move() {
        final int value = strategy.generate();
        if (value >= 4) {
            position++;
        }
    }

    public boolean isPositionSame(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
