import domain.CarName;
import domain.RaceGame;
import domain.RandomValueRule;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args)  {

        try {
            List<CarName> carNames = InputView.getCarsName();
            int tryCount = InputView.getTryCount();

            final RaceGame raceGame = new RaceGame(carNames, tryCount, new RandomValueRule());

            raceGame.start();


            ResultView.printWinners(raceGame.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
