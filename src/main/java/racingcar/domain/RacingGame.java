package racingcar.domain;

import racingcar.view.ResultView;

public class RacingGame {
    private RacingGameSetting setting;
    private RacingGameWinner winner;

    public RacingGame(RacingGameSetting setting) {
        this.setting = setting;
        this.winner = new RacingGameWinner();
    }

    public void race() {
        for (int i = 0; i < setting.getMoveTimes(); i++) {
            startLap();
        }
        winner.selectWinners(setting); // 직접 호출하도록 수정
    }

    private void startLap() {
        int random;
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();
        for (Car car : setting.getCarList()) {
            random = randomNumGenerator.makeNum();
            car.moveCar(random);
        }
        ResultView.printLapResult(setting.getCarList());
    }

}
