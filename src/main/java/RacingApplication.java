import controller.RacingController;
import domain.RandomNumberGenerator;

public class RacingApplication {

    public static void main(String[] args) {

        new RacingController().run(new RandomNumberGenerator());

    }

}
