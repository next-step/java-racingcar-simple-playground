package controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import model.Car;
import model.RacingGame;
import model.RandomNumberGenerator.DefaultRandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class RacingGameController {

    public void startRacingGame() {
        List<Car> cars = getCarsFromUserInput();
        int raceRounds = getRaceRoundsFromUserInput();

        RacingGame racingGame = new RacingGame(cars, new DefaultRandomNumberGenerator());

        startRace(racingGame, raceRounds);
        showWinners(racingGame);
    }

    // 자동차 이름 입력 및 변환
    private List<Car> getCarsFromUserInput() {
        String carNamesInput = InputView.getCarNames();
        return parseCarNames(carNamesInput);
    }

    // 자동차 이름을 파싱하여 리스트 생성
    private List<Car> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim) // 공백 제거
                .map(Car::new) // Car 객체 생성
                .collect(Collectors.toList());
    }

    // 경주 횟수 입력
    private int getRaceRoundsFromUserInput() {
        return InputView.getRaceRounds();
    }

    // 레이스 진행
    private void startRace(RacingGame racingGame, int raceRounds) {
        ResultView.printRaceResult();
        for (int i = 0; i < raceRounds; i++) {
            racingGame.raceSingleRound();
            ResultView.printRaceStatus(racingGame.getCars());
        }
    }

    // 우승자 출력
    private void showWinners(RacingGame racingGame) {
        List<Car> winners = racingGame.getWinners();
        ResultView.printWinners(winners);
    }
}
