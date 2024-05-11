import controller.CarRaceController;
import domain.Car;
import domain.CarRace;
import view.InputView;
import view.OutputView;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var carRace = new CarRace(carNames, tryCount, 3);
        final var carRaceController = new CarRaceController();
        System.out.println("실행 결과");

        carRaceController.race(carRace);
    }
}
