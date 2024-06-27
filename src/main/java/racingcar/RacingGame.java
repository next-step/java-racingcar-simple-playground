package racingcar;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.view.OutputView;

/**
 * n대의 자동차가 참여할 수 있다.
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.
 */
public class RacingGame {

    private final CarGroup carGroup;
    private final OutputView outputView;
    private final RandomNumberGenerator numberGenerator = new CarRandomNumberGenerator();

    public static RacingGame create(String input) {
        String[] carNames = input.split(",");
        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();
        return new RacingGame(cars);
    }

    private RacingGame(List<Car> carGroup) {
        this.carGroup = new CarGroup(carGroup);
        this.outputView = new OutputView();
    }

    public void play(int round) {
        outputView.printInit();
        for (int i = 0; i < round; i++) {
            carGroup.move(numberGenerator);
            outputView.printMovement(carGroup.cars());
        }
        outputView.printWinner(carGroup.getWinners());
    }
}

/*

neo,brie,brown
시도할 회수는 몇회인가요?
5

실행 결과
neo : -
brie : -
brown : -

neo : --
brie : -
brown : --

neo : ---
brie : --
brown : ---

neo : ----
brie : ---
brown : ----

neo : -----
brie : ----
brown : -----

neo : -----
brie : ----
brown : -----

neo, brown가 최종 우승했습니다.
 */
