import domain.RacingCar;
import view.InputView;
import view.ResultView;

public class Application {

    public static void main(String[] args) {

        String[] names = InputView.carName();
        int number = InputView.playNum();

        RacingCar racingCar = new RacingCar();
        racingCar.init(names);

        for (int i = 0; i < number; i++) {
            racingCar.play(names);
            ResultView.result(names, racingCar);
        }

        ResultView.printWinner(racingCar);
    }
}