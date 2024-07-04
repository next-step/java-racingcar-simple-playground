import java.util.List;

import model.Car;
import model.Game;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        List<Car> cars = InputView.inputCarNames().stream().map(it -> new Car(it)).toList();
        int tryCount = InputView.inputTryCount();
        Game game = new Game(cars);
        game.start(tryCount);
        OutputView.printWinner(game.getWinner());
    }
}
