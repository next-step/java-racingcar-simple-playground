package movingCarGame;

import java.util.Arrays;
import java.util.List;
import movingCarGame.domain.Car;
import movingCarGame.domain.CarGame;
import movingCarGame.view.InputView;
import movingCarGame.view.OutputView;

public class Application {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_TRY_GAMES = 100;
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        String input = inputView.readCarNames();
        List<Car> cars = parseNames(input);
        CarGame game = new CarGame(cars);

        input = inputView.readTryCount();
        int count = parseCount(input);

        outputView.printResult();
        for (int i = 0; i < count; i++) {
            game.play();
            outputView.printRoundResult(game.getCars());
        }
        outputView.printFinalWinner(game.getWinners());
    }

    public static List<Car> parseNames(String input) {
        String[] names = input.split(",");
        return Arrays.stream(names).map(name -> {
            validateName(name);
            return new Car(name);
        }).toList();
    }

    public static int parseCount(String inputNumber) {
        int count = parseInt(inputNumber);
        validateCount(count);
        return count;
    }

    private static void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자를 넘을 수 없습니다.");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름의 길이는 최소 한글자를 넣어야 합니다.");
        }
    }

    private static void validateCount(int count) {
        if (count > MAX_TRY_GAMES) {
            throw new IllegalArgumentException("시도 횟수는 " + MAX_TRY_GAMES + " 이하로 입력해주세요.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private static int parseInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
