import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;
    private final RaceHistory raceHistory = new RaceHistory();

    public RacingGame(List<String> carNames, int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다");
        }
        this.tryCount = tryCount;
        MoveCondition moveCondition = new MoveConditionImpl();

        List<Car> carList = carNames.stream()
                .map(name -> new Car(name, moveCondition))
                .toList();

        this.cars = new Cars(carList);
    }

    public void race() {
        for (int i = 0; i < tryCount; i++) {
            cars.moveAllOneRound();
            raceHistory.addRound(cars.getCarInfos()); //기록
        }
    }

    public List<String> getWinners() {
        RaceJudge judge = new RaceJudge(cars);
        return judge.getWinnerNames();
    }

    public RaceHistory getRaceHistory() {
        return raceHistory;
    }

}

