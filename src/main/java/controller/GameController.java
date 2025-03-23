package controller;

import domain.Cars;
import domain.MovingStrategy;
import domain.Racing;
import domain.RandomMovingStrategy;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {

    public void start() {

        MovingStrategy movingStrategy = new RandomMovingStrategy();

        // 사용자 입력(n대의 자동차 이름, 라운드 횟수)
        final List<String> carNames = InputView.scanCarNames();
        final int roundCount = InputView.scanRoundCount();

        //참가 자동차 목록 생성
        final Cars cars = new Cars(carNames);
        Racing racing = new Racing(cars, movingStrategy, roundCount);

        // 경주 시작 & 라운드 별 결과 출력
        OutputView.printResultMessage(); // "실행 결과" 메시지 출력
        race(racing, roundCount);

        // 최종 우승자 리스트 출력
        OutputView.printWinners(Cars.getWinners());
    }

    private void race(Racing racing, final int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            racing.round();
            OutputView.printRound(racing.getCars());
        }
    }
}
