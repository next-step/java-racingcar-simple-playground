import generator.RandomNumberGenerator;
import java.util.List;
import ui.ConsoleReader;
import ui.InputView;

public class CarRaceApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView(new ConsoleReader());
        Circuit circuit = new Circuit(new RandomNumberGenerator());

        List<String> carNames = inputView.inputCarNames();
        circuit.registerCars(carNames);

        int raceTryCount = inputView.inputRaceTryCount();
        circuit.startRace(raceTryCount);
    }
}
