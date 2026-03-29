import controller.RaceController;
import model.Cars;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        RaceController raceController = new RaceController(new InputView(new Scanner(System.in)), new OutputView(), new Cars());
        raceController.addCarsFromUser();
        raceController.playRace();
    }
}