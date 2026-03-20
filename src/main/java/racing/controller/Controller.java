package racing.controller;

import racing.domain.Car;
import racing.view.InputView;

import racing.domain.Cars;
import racing.domain.Race;
import racing.domain.RandomMoveStrategy;
import racing.view.OutputView;

public class Controller {
    public static void main(String[] args) {
        // [1] 자동차 이름 및 시도 횟수 입력 받기
        String carNameInput = InputView.inputCarName();
        int trialNumber = InputView.inputTrialNumberCount();
        Race.validateTrialCount(trialNumber);
        // [2] 데이터 변환: 문자열 -> 자동차 객체 리스트
        Cars cars = new Cars(carNameInput);
        Race race = new Race(cars);
        //[3] 레이씽 경기 시작
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy();
        for (int i = 0; i < trialNumber; i++) {
            race.playRound(moveStrategy);
            OutputView.printRoundResult(race.getParticipatingCars());
            OutputView.println();
        }
        //[4] 결과 출력
        OutputView.printWinners(race.getWinners());

    }
}