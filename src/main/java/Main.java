import domain.Car;
import domain.MakeRandomNum;
import domain.NumberGenerator;
import domain.Play;
import view.ResultView;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static view.InputView.getCarNames;
import static view.InputView.getTryCount;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = getCarNames();
        int totalPlay = 0;
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        NumberGenerator numberGenerator = new MakeRandomNum();
        Play race = new Play(cars, numberGenerator);
        totalPlay = getTryCount();
        for (int i = 0; i < totalPlay; i++) {
            race.playRound();
            ResultView.printRace(cars);
        }
        race.getWinners(cars);
        ResultView.printWinner(race.getWinner());
    }
}
