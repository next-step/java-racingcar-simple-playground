import model.Car;
import view.InputController;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        RacingGame racingGame = new RacingGame();

        List<String> nameList = inputController.inputNames();
        int times = inputController.inputTimes();

        nameList.forEach((name) -> {
            racingGame.join(new Car(name));
        });

        racingGame.race(times);
        racingGame.printWinners();
    }
}
