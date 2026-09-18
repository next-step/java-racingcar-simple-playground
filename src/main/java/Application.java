import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> names = inputView.getCarName();
        int tryCount = inputView.getTryCount();

        CarMovement carMovement = new RandomMovement();
        Cars cars = new Cars(names, carMovement);
        Race race = new Race(cars);

        for (int i = 0; i < tryCount; i++) {
            race.oneRound();
            outputView.printRound(cars.getCars());
        }

        List<Car> winners = race.findWinners();
        outputView.printWinner(winners);
    }
}
