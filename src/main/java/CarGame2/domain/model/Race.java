package CarGame2.domain.model;

import CarGame2.domain.service.Generator;
import java.util.List;

public class Race {

    private final Cars cars;
    private final int rounds;
    private final Generator generator;

    public Race(List<String> carNames, int rounds, Generator generator) {
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
