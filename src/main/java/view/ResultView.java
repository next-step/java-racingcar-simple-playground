package view;

import domain.Car;
import domain.Cars;
import domain.RacingGameService;

public class ResultView {

    private final RacingGameService racingGame;

    public ResultView(RacingGameService racingGame) {
        this.racingGame = racingGame;
    }

    public void printRoundResults(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printRaceResults() {
        String winnerNames = racingGame.findWinnerName();
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}
