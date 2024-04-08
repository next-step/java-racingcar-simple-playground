package domain;

public class Car {
    private NumberGenerateStrategy strategy;
    private CarName name;
    private int distance = 0;

    public Car(NumberGenerateStrategy strategy,
               CarName name) {
        this.strategy = strategy;
        this.name = name;
    }

    public String getName() {
        return name.value();
    }

    public int getDistance() {
        return distance;
    }

    public void race() {
        int num = strategy.generate();
        if (num >= 4) {
            ++distance;
        }
    }
}
