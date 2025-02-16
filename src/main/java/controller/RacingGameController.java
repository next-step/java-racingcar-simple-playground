package controller;

import domain.RacingGameService;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingGameController {

    private final static int NAME_LENGTH = 5;
    private final RacingGameService racingGame;
    private final InputView inputView = new InputView();
    private final ResultView resultView;

    public RacingGameController() {
        this(new Random());
    }

    public RacingGameController(Random random) {
        this.racingGame = new RacingGameService(random);
        this.resultView = new ResultView(racingGame);
    }

    public void gamePlay() {
        List<String> carNames = inputView.inputCarNames();
        validateNameLength(carNames);
        racingGame.carList(carNames);

        int rounds = inputView.inputRaceRounds();
        rounds = ensurePositiveRounds(rounds);

        System.out.println("실행결과");
        racingGame.gameStart(rounds, resultView);
        resultView.printRaceResults();
    }

    public void validateNameLength(List<String> carsName) {
        for (String carName : carsName) {
            validateInput(carName);
        }
    }

    public void validateInput(String carName) {
        if (carName.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야합니다.");
        }
    }

    public int ensurePositiveRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도할 회수는 1이상이어야 합니다.");
        }
        return rounds;
    }
}
