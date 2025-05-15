package manager;

import data.CarSnapShot;
import data.RoundResult;
import domain.RacingWithCars;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameManager {

    private final RacingWithCars racingWithCars;

    public RacingGameManager(RacingWithCars racingWithCars) {
        this.racingWithCars = racingWithCars;
    }

    public void raceAndPrintRoundResults() {
        int times = racingWithCars.getTimes();
        for (int i = 0; i < times; i++) {
            RoundResult roundResult = racingWithCars.raceOneRound();
            OutputView.printRoundResult(roundResult);
        }
    }

    public List<String> getWinnerNames() {
        List<CarSnapShot> winners = racingWithCars.getWinner();

        return winners.stream()
                .map(CarSnapShot::getCarName)
                .collect(Collectors.toList());
    }
}
