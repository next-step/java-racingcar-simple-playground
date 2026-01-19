package domain;

public final class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void run(int tryCount, RandomNumberGenerator generator) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(generator);
        }
    }

    public Cars cars() {
        return cars;
    }
}
