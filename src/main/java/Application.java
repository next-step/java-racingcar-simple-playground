import domain.*;
import domain.movement.NumberGenerater;
import domain.movement.RandomNumberGenerater;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> names = inputView.getCarName();
        int tryCount = inputView.getTryCount();

        NumberGenerater numberGenerater = new RandomNumberGenerater();
        Cars cars = new Cars(names, numberGenerater);
        Race race = new Race(cars);

        for (int i = 0; i < tryCount; i++) {
            race.oneRound();
            outputView.printRound(cars.getCars());
        }

        List<Car> winners = race.findWinners();
        outputView.printWinner(winners);
    }
}
