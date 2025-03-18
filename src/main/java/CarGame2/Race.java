package CarGame2;

import java.util.List;

public class Race {

    private final Cars cars;
    private final int rounds;
    private final OutputHandler raceOutput;

    public Race(List<String> carNames, int rounds, Generator generator, OutputHandler raceOutput) {
        validateGenerator(generator);
        this.rounds = rounds;
        this.cars = new Cars(carNames, generator);
        this.raceOutput = raceOutput;
    }

    private void validateGenerator(Generator generator) {
        if (generator == null) {
            throw new IllegalArgumentException("Race에서 Generator가 null입니다.");
        }
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            playRound(i + 1);
        }
        printWinners();
    }

    private void playRound(int curRound) {
        raceOutput.printRoundStart(curRound);
        cars.moveAll();
        for (Car car : cars.getCars()) {
            raceOutput.printCarStatus(car);
        }
        raceOutput.printRoundEnd();
    }

    private void printWinners() {
        FindWinner findWinner = new FindWinner(cars);
        raceOutput.printWinners(findWinner.getWinners());
    }
}
