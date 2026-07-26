import domain.*;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static view.InputView.getCarNames;
import static view.InputView.getTryCount;

public class Main {
    public static void main(String[] args) {
        List<Car> carsList = new ArrayList<>();
        String[] carNames = getCarNames();
        int totalPlay = 0;
        for (int i = 0; i < carNames.length; i++) {
            carsList.add(new Car(carNames[i]));
        }
        Cars cars = new Cars(carsList);
        NumberGenerator numberGenerator = new MakeRandomNum();
        Play race = new Play(cars, numberGenerator);
        totalPlay = getTryCount();
        for (int i = 0; i < totalPlay; i++) {
            race.playRound();
            ResultView.printRace(cars);
        }
        ResultView.printWinner(cars.getWinner());
    }
}
