import controller.RacingGameController;
import model.RacingNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new RacingNumberGenerator());
        racingGameController.run();
    }
}
