import utils.NumberGenerator;
import utils.RandomNumberGenerator;

public class Main {

    public static void main(String[] args) {
        RacingGameView view = new RacingGameView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        RacingGameController controller = new RacingGameController(view, numberGenerator);
        controller.start();
    }

}
