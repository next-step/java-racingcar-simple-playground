import java.util.stream.Stream;
import view.InputView;
import controller.RacingGameController;
import model.Car;

import java.util.List;

public class Application {

    public static void main(final String... args) {

        final var carNamesInput = InputView.getCarNames();
        final var raceRounds = InputView.getRaceRounds();

        List<Car> cars = parseCarNames(carNamesInput);

        RacingGameController racingGameController = new RacingGameController();
        racingGameController.startRacingGame(cars, raceRounds);
    }

    // 자동차 이름을 List<Car>로 변환
    private static List<Car> parseCarNames(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }
}
