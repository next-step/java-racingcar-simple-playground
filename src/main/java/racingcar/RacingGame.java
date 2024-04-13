package racingcar;

import java.util.List;
import racingcar.domain.MoveResults;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Circuit circuit;

    public RacingGame(final InputView inputView, final OutputView outputView, final Circuit circuit) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.circuit = circuit;
    }

    public void run() {
        registerCars();
        startRace();
        awardRace();
    }

    private void registerCars() {
        List<String> carNames = inputView.inputCarNames();
        circuit.registerCars(carNames);
    }

    private void startRace() {
        int raceTryCount = inputView.inputRaceTryCount();
        List<MoveResults> moveResults = circuit.startRace(raceTryCount);
        outputView.printMoveResults(moveResults);
    }

    private void awardRace() {
        List<String> winners = circuit.findWinners();
        outputView.printWinners(winners);
    }
}
