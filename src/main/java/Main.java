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
        int totalPlay = getTryCount();
        for (int i = 0; i < carNames.length; i++) {
            carsList.add(new Car(carNames[i]));
        }
        Cars cars = new Cars(carsList);
        NumberGenerator numberGenerator = new MakeRandomNum();
        Play race = new Play(cars, numberGenerator);
        System.out.println("실행결과");
        for (int i = 0; i < totalPlay; i++) {
            ResultView.printRace(cars);
            race.playRound();
        }
        ResultView.printWinner(cars.getWinner());
    }
}
