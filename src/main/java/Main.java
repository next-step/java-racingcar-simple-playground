import controller.RacingGameController;
import domain.racegame.RandomMoveStrategy;

public class Main {
    public static void main(String[] args) {

        RacingGameController racingGameController = new RacingGameController(new RandomMoveStrategy());

        racingGameController.racingApplication();

    }
}
