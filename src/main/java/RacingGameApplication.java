import controller.RacingGameController;
import domain.RacingGame.RandomNumberGenerator;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameController racingGameController
            = new RacingGameController(new RandomNumberGenerator());

        racingGameController.gameStart();
    }

}
