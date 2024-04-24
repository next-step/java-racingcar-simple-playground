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
    private final NumberGenerator numberGenerator;

    public RacingGame(final InputView inputView,
                      final OutputView outputView,
                      final NumberGenerator numberGenerator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        RacingCircuit circuit = createRacingCircuit();
        startRace(circuit);
        awardRace(circuit);
    }

    private RacingCircuit createRacingCircuit() {
        Cars cars = generateRacingCars();
        int raceTryCount = inputView.inputRaceTryCount();
        return new RacingCircuit(cars, raceTryCount);
    }

    private Cars generateRacingCars() {
        List<String> carNames = inputView.inputCarNames();
        return Cars.createCarsWithGenerator(carNames, numberGenerator);
    }

    private void startRace(final RacingCircuit circuit) {
        Map<Integer, Cars> roundRecords = circuit.startRace();
        outputView.printMoveResults(roundRecords);
    }

    private void awardRace(final RacingCircuit circuit) {
        Cars winners = circuit.findWinners();
        outputView.printWinners(winners);
    }
}
