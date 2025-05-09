import domain.Car;
import domain.CarNameParser;
import domain.CarRace;
import domain.NumberGenerator;
import domain.NumberGeneratorImpl.RandomNumberGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class CarRaceApp {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final CarNameParser carNameParser = new CarNameParser();
        final NumberGenerator numberGenerator = new RandomNumberGenerator();

        List<Car> cars = getCars(outputView, inputView, carNameParser);
        int gameRounds = getGameRounds(outputView, inputView);
        final CarRace carRace = new CarRace(cars, gameRounds, numberGenerator);
        carRace.start();

        outputView.printGameResult(carRace.getGameRoundsOutput());
        outputView.printWinnerCarNames(carRace.getWinnerCarNames());
    }

    private static int getGameRounds(OutputView outputView, InputView inputView) {
        outputView.printInputGameRounds();
        return inputView.readGameRounds();
    }

    private static List<Car> getCars(OutputView outputView, InputView inputView,
                                     CarNameParser carNameParser) {
        outputView.printInputCarsName();
        String carNames = inputView.readCarNames();
        return carNameParser.parse(carNames).stream().map(Car::new).toList();
    }
}
