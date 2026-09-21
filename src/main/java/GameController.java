import java.util.ArrayList;

public class GameController {
    private int roundCount;
    private Cars cars;
    private View view;

    public GameController(View view) {
        cars = new Cars(new ArrayList<Car>());
        this.view = view;
    }

    public void run() {
        String names = view.inputCarNames();
        cars.addCars(names);
        roundCount = view.inputRoundCount();
        playRace();
    }

    private void playRace() {
        view.printStartMessage();
        CarRace carRace = new CarRace(cars, new RandomNumGenerator());
        for (int i = 0; i < roundCount; i++) {
            carRace.moveCars();
            view.printResult(cars);
        }
        view.printWinners(carRace.getWinners());
    }
}
