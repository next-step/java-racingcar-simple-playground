package controller;

import domain.Cars;
import domain.Racing;
import domain.NumberGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingController {

    public void run(NumberGenerator numberGenerator) {

        OutputView.printInputCarNames();
        List<String> carNames = InputView.getCarNames();
        Cars carList = Cars.create(carNames, numberGenerator);

        OutputView.printInputRoundNumber();
        int roundNumber = InputView.getRoundNumber();

        Racing racing = new Racing(carList);

        OutputView.printResult();
        playRace(racing, carList, roundNumber);

        Cars winnerList = racing.findWinners();
        OutputView.printWinners(winnerList.getCars());
    }

    public void playRace(Racing racing, Cars carList, int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            racing.playRound();
            OutputView.printProcess(carList.getCars());
        }
    }

}
