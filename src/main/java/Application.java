import domain.*;
import domain.movement.CarMovement;
import domain.movement.RandomMovement;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> names = inputView.getCarName();
        int tryCount = inputView.getTryCount();

        CarMovement carMovement = new RandomMovement();
        Cars cars = new Cars(names, carMovement);
        Race race = new Race(cars);

        for (int i = 0; i < tryCount; i++) {
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
            race.oneRound();
            outputView.printRound(cars.getCars());
        }

        List<Car> winners = race.findWinners();
        outputView.printWinner(winners);
    }
}
