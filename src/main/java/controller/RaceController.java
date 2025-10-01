package controller;

import domain.CreateCar;
import domain.Cars;
import domain.RaceManage;
import view.InputView;
import view.ResultView;

import java.util.Arrays;

public class RaceController {
    private static final int MAX_NAME_LENGTH =4;
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final CreateCar createCar = new CreateCar();

    public void run() {
        String[] carNames = getValidCarName();
        Cars cars = new Cars(Arrays.asList(createCar.createCar(carNames)));

        int rounds = inputView.readRounds();

        RaceManage raceManage = new RaceManage();
        raceManage.startRace(cars, rounds);
        resultView.printWinner(cars.findWinnerNames().toString());
    }

    private boolean isValidCarNames(String[] names) {
        for (String name : names) { //이걸 depth 2이하로 아무리 생각해도 모르겠음
            if (name.length() > MAX_NAME_LENGTH ) {
                System.out.println("자동차 이름은 4자 이하로 입력해야 합니다.");
                return false;
            }
        }
        return true;
    }

    private String[] getValidCarName() {
        String[] carNames = inputView.getCarNames();
        while (!isValidCarNames(carNames)) {
            carNames = inputView.getCarNames();
        }
        return carNames;
    }

}
