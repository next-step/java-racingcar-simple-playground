import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.NumberUtils;

@DisplayName("자동차 경주 테스트")
public class RacingGameTest {

    @Test
    @DisplayName("자동차가 전진하는지 확인한다.")
    void isForward() {
        int number = NumberUtils.getRandomNumberFourToNine();
        boolean isForward = number >= 4 && number <= 9;
        Assertions.assertTrue(isForward);
    }

    @Test
    @DisplayName("자동차가 멈추는지 확인한다.")
    void isStop() {
        int number = NumberUtils.getRandomNumberZeroToThree();
        boolean isStop = number >= 0 && number <= 3;
        Assertions.assertTrue(isStop);
    }

    @Test
    @DisplayName("경주에서 우승한 자동차를 가려낸다. (여러 명일 수 있음)")
    void GetWinners() {
        Car car1 = new Car("일등", 2);
        Car car2 = new Car("이등", 2);
        Car car3 = new Car("삼등", 1);
        Car car4 = new Car("사등", 0);

        List<Car> cars = List.of(car1, car2, car3, car4);
        RacingGame racingGame = new RacingGame(cars);

        List<Car> winners = racingGame.getWinners();

        Assertions.assertEquals(2, winners.size());
    }

}

