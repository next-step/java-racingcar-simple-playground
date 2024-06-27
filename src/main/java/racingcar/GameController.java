package racingcar;

import racingcar.view.InputView;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        String carNames = inputView.inputCarNames();
        int round = inputView.inputRound();
        RacingGame racingGame = RacingGame.create(carNames);
        racingGame.play(round);
    }
}
