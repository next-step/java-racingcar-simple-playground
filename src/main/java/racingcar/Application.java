package racingcar;

import racingcar.controller.GameManageController;
import racingcar.model.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        GameManageController gameManageController = new GameManageController();
        gameManageController.readyRacingGame();
        gameManageController.runRacingGame(randomNumberGenerator);
    }
}
