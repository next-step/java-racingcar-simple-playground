package domain;

public class Car {

    private final NumberGenerateStrategy strategy;
    private final CarName name;
    private int position;

    public Car(final NumberGenerateStrategy strategy,
               final String name) {
        this(strategy, name, 0);
    }

    public Car(final NumberGenerateStrategy strategy,
               final String name,
               final int position) {
        this.strategy = strategy;
        this.name = CarName.from(name);
        this.position = position;
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
        return name.value();
    }

    public int getPosition() {
        return position;
    }
}
