package domain;

public class Car {

    private final NumberGenerateStrategy strategy;
    private final String name;
    private int position;

    public Car(final NumberGenerateStrategy strategy,
               final String name) {
        this.strategy = strategy;
        this.name = name;
        this.position = 0;
    }

    public Car(final NumberGenerateStrategy strategy,
               final String name,
               final int position) {
        this.strategy = strategy;
        this.name = name;
        this.position = position;
    }

    public void move() {
        final int value = strategy.generate();
        if (value >= 4) {
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
