package CarGame2.domain.model;

import CarGame2.domain.service.NumberGenerator;
import java.util.List;

public class Race {

    private final Cars cars;
    private final int rounds;
    private final NumberGenerator generator;

    public Race(List<String> carNames, int rounds, NumberGenerator generator) {
        this.rounds = rounds;
        this.cars = new Cars(carNames);
        this.generator = generator;
    }

    public void playRound() {
        cars.moveAll(generator);
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }

    public int getRounds() {
        return rounds;
    }

    public Cars getCars() {
        return cars;
    }
}
