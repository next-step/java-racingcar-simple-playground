import java.util.ArrayList;
import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) throws Exception {

        InputView inputView = new InputView();

        // 1. 자동차 이름 입력 및 검증
        String[] carsName = inputView.inputCarNames();
        List<Car> cars = createCars(carsName);

        RacingGame racingGame = new RacingGame(cars);
        ResultView resultView = new ResultView();

        // 2. 시도할 횟수 입력
        int rounds = inputView.inputRaceRounds();

        // 3. 게임 실행
        racingGame.gameStart(rounds);

        // 4. 결과 출력
        List<Car> winnerCars = racingGame.getWinner();
        String winnerNames = racingGame.findWinnerName(winnerCars);

        resultView.printResult(winnerCars, winnerNames);
    }

    public static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}
