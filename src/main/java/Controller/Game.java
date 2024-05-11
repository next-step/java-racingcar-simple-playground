package Controller;

import Creator.RandomNumberCreator;
import Model.RacingGame;
import Utils.StringToCar;
import View.InputView;
import View.ResultView;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        final List<String> carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        StringToCar stringToCar = new StringToCar(carNames);
        final RacingGame racingGame = new RacingGame(stringToCar.getCarList(), tryCount,new RandomNumberCreator());
        racingGame.race();
        ResultView.printWinners(racingGame.getWinners());
    }

}
