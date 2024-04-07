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

        final var carRace = new CarRace(carNames, tryCount);
        System.out.println("실행 결과");
        carRace.raceStart();

        OutputView.printWinners(carRace.getWinners());
    }
}
