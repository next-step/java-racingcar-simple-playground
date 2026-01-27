package domain;

import java.util.ArrayList;
import java.util.List;

public final class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public List<RoundResult> run(int tryCount, RandomNumberGenerator generator) {
        List<RoundResult> results = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(generator);
            results.add(RoundResult.from(cars));
        }

        return results;
    }

    public Cars cars() {
        return cars;
    }
}
