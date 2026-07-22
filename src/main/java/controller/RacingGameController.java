package controller;

import domain.CarListInitializer;
import domain.RacingCar;
import domain.RacingGame;
import domain.rand.Move;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    private final InputView inputView;
    private final Move move;

    public RacingGameController(InputView inputView, Move move) {
        this.inputView = inputView;
        this.move = move;
    }

    private RacingGame gameSetUp() {

        List<RacingCar> carList = new ArrayList<>();
        while (carList == null || carList.isEmpty()) {
            String[] names = inputView.inputNames();
            carList = carListSetUp(names);
        }

        int turnCount = inputView.inputTurnCount();

        return new RacingGame(carList, turnCount, move);
    }

    private List<RacingCar> carListSetUp(String[] names) {
        try {
            return CarListInitializer.initCarList(names);
        } catch (IllegalArgumentException e) {
            // FIXME ResultView로 리팩토링
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void gameStart() {

        RacingGame racingGame = gameSetUp();

        play(racingGame);

        ResultView.printFinalResult(racingGame.getWinnerNames());
    }

    private void play(RacingGame racingGame) {
        ResultView.printGameStart();

        while (!racingGame.isFinished()) {
            racingGame.start();
            ResultView.printTurnResult(racingGame.getCarList());
        }
    }
}
