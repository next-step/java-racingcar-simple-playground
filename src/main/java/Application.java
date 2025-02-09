import controller.RaceController;
import view.RaceOutputView;

import java.util.Random;

public class Application {

    public static void main(String[] args) {
        Random random = new Random();
        RaceOutputView raceOutputView = new RaceOutputView();
        RaceController raceController = new RaceController(raceOutputView, random);
        raceController.start();
    }
}
