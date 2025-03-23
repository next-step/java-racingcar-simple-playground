package domain;

public class Racing {

    private final Cars cars;
    MovingStrategy movingStrategy;
    int roundCount;

    public Racing(Cars cars, MovingStrategy movingStrategy, int roundCount) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
        this.roundCount = roundCount;
    }

    public void round() {
        cars.move(movingStrategy);
    }

    public Cars getCars() {
        return cars;
    }
}
