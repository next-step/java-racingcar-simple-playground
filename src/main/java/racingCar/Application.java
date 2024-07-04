package racingCar;

import racingCar.view.InputView;
import racingCar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String inputCars = InputView.getCarNames();

        Racing racing = new Racing(inputCars);
        racing.startRacing();

        OutputView.printWinner(racing.getWinner());
    }
}
