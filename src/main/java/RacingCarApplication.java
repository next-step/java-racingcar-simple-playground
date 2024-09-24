import controller.RacingGameController;
import domain.RandomNumberGenerateStrategy;


public class RacingCarApplication {
    public static void main(String[] args) {
        final RacingGameController controller = new RacingGameController();
        controller.run(new RandomNumberGenerateStrategy());
    }

}
