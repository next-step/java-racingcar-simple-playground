import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void run() {
        String input = InputView.getCarNames();
        String[] carNames = input.split(",");
        int number = InputView.getTrynumber();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        OutputView.getOutput();

        RacingGame racingGame = new RacingGame(cars, number);
        racingGame.playGame();
    }
}
