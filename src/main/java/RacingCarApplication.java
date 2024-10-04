import controller.RacingGameController;
import domain.NumberGenerateStrategy;
import domain.RandomNumberGenerateStrategy;

public class RacingCarApplication {
    public static void main(String[] args) {
        NumberGenerateStrategy strategy = new RandomNumberGenerateStrategy();
        final RacingGameController controller = new RacingGameController(strategy);
        controller.run();
    }
}
