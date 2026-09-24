import controller.RacingController;
import numberGenerator.RandomNumberGenerator;

public class CarRaceMain {
    public static void main(String[] args) {
        RacingController controller = new RacingController(new RandomNumberGenerator());
        controller.run();
    }
}
