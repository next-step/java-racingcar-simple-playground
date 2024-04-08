package step4;

import step4.controller.RacingCarController;
import step4.view.InputView;
import step4.view.OutputView;

public class RacingCarMain {
    public static void main(String[] args) {
        final String carNames=InputView.getCarNames();
        final int tryNo=InputView.getRaceCount();

        RacingCarController racingCarController=new RacingCarController(carNames,tryNo);
        racingCarController.startRace();

        OutputView.printRaceWinner(racingCarController.getWinners());
    }
}
