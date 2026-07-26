package racingcar;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGameWinner;
import racingcar.domain.RacingLap;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

import java.util.List;
import racingcar.view.ResultView;

public class Application {
    public static void main(final String... args) {
        final List<String> carNames = InputView.setCarNames();
        RacingCars racingCars = new RacingCars(carNames);   //입력을 받자마자 검증

        final int lapCount = InputView.setLapCount();
        RacingLap racingLap = new RacingLap(lapCount);  //입력을 받자마자 검증

        //검증된 것으로 인스턴스를 생성
        RacingGame racingGame = new RacingGame(racingCars.getCarsList(), racingLap.getLapCount());

        System.out.println("실행 결과");
        for (int i = 0; i < racingLap.getLapCount(); i++) {
            ResultView.printLapResult(racingGame.startLap());
        }

        RacingGameWinner racingGameWinner = new RacingGameWinner();
        ResultView.printWinners(racingGameWinner.selectWinners(racingGame));

        InputView.closeScanner();
    }
}
