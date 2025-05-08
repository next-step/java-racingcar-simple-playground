import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> names = Input.getNames();
        int tryCount = Input.getTryCount();

        Cars cars = new Cars(names.stream().map(Car::new).toList());
        RacingGame racingGame = new RacingGame(cars, tryCount);
        racingGame.run();
    }
}
