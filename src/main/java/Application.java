import config.RacingGameConfig;
import controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameConfig config = new RacingGameConfig();
        RacingGameController controller = config.racingGameController();
        controller.run();
    }
}
