import controller.CarController;
import view.InputView;

public class CarRacingApplication {
    public static void main(String[] args){
        final String[] carNames = InputView.getCarNames();
        final int raceCount = InputView.getRaceCount();

        final CarController carController = new CarController(carNames, raceCount);

    }
}
