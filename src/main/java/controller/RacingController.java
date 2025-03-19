package controller;

import domain.Car;
import domain.Cars;
import domain.Racing;
import domain.NumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingController {

    Racing racing;
    Cars carList;
    Cars winnerList;
    int RoundNumber;

    public void run(NumberGenerator numberGenerator) {
        carList = Cars.create(InputView.getCarNames(), numberGenerator);
        RoundNumber = InputView.getRoundNumber();
        racing = new Racing(carList);

        OutputView.printResult();
        playRace();

        winnerList = racing.findWinners();
        OutputView.printWinners(winnerList.getCars());
    }

    public void playRace() {
        for (int i = 0; i < RoundNumber; i++) {
            racing.playRound();
            OutputView.printProcess(carList.getCars());
        }
    }
}
