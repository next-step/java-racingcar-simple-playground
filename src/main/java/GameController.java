import java.util.ArrayList;

public class GameController {
    private ArrayList<Car> cars;
    private int roundCount;
    private View view;

    public GameController(View view) {
        cars = new ArrayList<>();
        this.view = view;
    }

    public void run() {
        String names = view.inputCarNames();
        addCars(names);
        roundCount = view.inputRoundCount();
        playRace();
    }

    private void addCars(String value) {
        String[] names = value.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
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
