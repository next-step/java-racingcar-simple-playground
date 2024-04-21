package racingcar;

import java.util.List;
import java.util.Map;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingCircuit;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCircuit racingCircuit;
    private final NumberGenerator numberGenerator;

    public RacingGame(final InputView inputView,
                      final OutputView outputView,
                      final RacingCircuit racingCircuit,
                      final NumberGenerator numberGenerator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCircuit = racingCircuit;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        registerCars();
        startRace();
        awardRace();
    }

    private void registerCars() {
        List<String> carNames = inputView.inputCarNames();
        Cars cars = Cars.createCarsWithGenerator(carNames, numberGenerator);
        racingCircuit.registerCars(cars);
    }

    private void startRace() {
        int raceTryCount = inputView.inputRaceTryCount();
        Map<Integer, Cars> roundRecords = racingCircuit.startRace(raceTryCount);

        outputView.printMoveResults(roundRecords);
    }

    private void awardRace() {
        Cars winners = racingCircuit.findWinners();

        outputView.printWinners(winners);
    }
}
