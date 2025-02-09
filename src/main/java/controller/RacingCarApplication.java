package controller;

import domain.Race;
import domain.RacingCar;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingCarApplication {

    // 레이싱 게임 실행
    public void run() {
        try {
            List<RacingCar> cars = InputView.getCarNames();
            int rounds = InputView.getRoundsFromUser();

            Race race = new Race(cars);
            race.race(rounds);

            ResultView.printRaceResults(race);
            ResultView.printWinners(race.findWinners());
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
