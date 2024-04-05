import java.util.ArrayList;
import java.util.List;
import utils.Parser;
import validator.InputValidator;
import view.GamePrinter;
import view.GameReader;

public class Main {

    public static void main(String[] args) {
        String carNames = GameReader.getNames();
        List<Car> cars = new ArrayList<>();
        List<String> parsedNames = Parser.parseStringArray(carNames);
        for (String name : parsedNames) {
            cars.add(new Car(name));
        }

        int gameCount;
        gameCount = GameReader.getCount();
        InputValidator.validateGameCount(gameCount);

        CarRace carRace = new CarRace(cars);
        GamePrinter.printResultStart();
        carRace.raceStart(gameCount);
        List<String> winners = carRace.selectWinners();
        GamePrinter.printRaceWinners(winners);
    }

}
