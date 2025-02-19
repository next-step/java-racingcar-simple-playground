import controller.RacingGameController;
import service.RacingGameService;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGameService racingGameService = new RacingGameService();

        RacingGameController racingGameController = new RacingGameController(racingGameService);

        racingGameController.racingGame();
    }
}
