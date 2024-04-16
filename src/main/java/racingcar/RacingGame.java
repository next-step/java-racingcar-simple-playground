package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingCircuit;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCircuit racingCircuit;

    public RacingGame(final InputView inputView, final OutputView outputView, final RacingCircuit racingCircuit) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCircuit = racingCircuit;
    }

    public void run() {
        registerCars();
        startRace();
        awardRace();
    }

    private void registerCars() {
        List<String> carNames = inputView.inputCarNames();
        racingCircuit.registerCars(carNames);
    }

    private void startRace() {
        int raceTryCount = inputView.inputRaceTryCount();
        List<Cars> carsSet = racingCircuit.startRace(raceTryCount);

        outputView.printMoveResults(carsSet);
    }

    private void awardRace() {
        Cars winners = racingCircuit.findWinners();

        outputView.printWinners(winners);
    }
}
