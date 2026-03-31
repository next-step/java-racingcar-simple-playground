package domain;

import view.ResultView;
import view.InputView;

import java.util.ArrayList;

public class RacingGame {
    private static final ResultView resultView = new ResultView();
    private static final InputView inputView = new InputView();
    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    public void run() {
        String [] cars = inputView.getCarNames();
        ArrayList<Car> carNamesArray = new ArrayList<>();
        for(String car: cars) {
            carNamesArray.add(new Car(car.trim(), randomNumberGenerator ));
        }

        int tryCount = inputView.getValidateTryCount();

        resultView.printPlayResult(tryCount, carNamesArray);
        resultView.printWinner(carNamesArray);
    }

    public void validateCarNameInput(String[] carNamesArray) {
        if(carNamesArray.length < 2) {
            throw new IllegalArgumentException("쉼표로 구분된 2대 이상의 자동차를 입력해주세요.");
        }
    }

    public void validateTryCountInput(int count) {
        if(count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1번 이상이어야 해요!");
        }
    }
}
