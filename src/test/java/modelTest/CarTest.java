package modelTest;

import domain.Car;
import global.RandomUtil;
import global.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.RacingGameService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("Random숫자가 3이하인 경우 테스트")
    void ForwordOrStayIfNumberLessThan4() {
        RacingGameService racingGameService = new RacingGameService();
        RandomUtil testNumberGenerator = new TestNumberGenerator(3);

        Car car = new Car("avante", testNumberGenerator);
        car.moveForwardOrStay();

        assertThat(car.getMoveDistance())
                .as("car의 moveDistance는 1이어야 합니다.")
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Random숫자가 4이상인 경우 테스트")
    void ForwordOrStayIfNumberMoreThan4() {
        RacingGameService racingGameService = new RacingGameService();
        RandomUtil testNumberGenerator = new TestNumberGenerator(4);
        Car car = new Car("avante", testNumberGenerator);

        car.moveForwardOrStay();

        assertThat(car.getMoveDistance())
                .as("car의 moveDistance는 2이어야 합니다.")
                .isEqualTo(2);
    }

    @Test
    @DisplayName("moveDistance가 높은 Cars 검증 테스트")
    void getLongestMoveDistanceTest() {
        RacingGameService racingGameService = new RacingGameService();
        List<Car> cars = new ArrayList<>();

        for (int i = 2; i < 5; i++) {
            RandomUtil testNumberGenerator = new TestNumberGenerator(i);

            Car car = new Car("car" + i, testNumberGenerator);
            car.moveForwardOrStay();
            cars.add(car);
        }

        String[] winner = racingGameService.getWinners(cars);

        assertThat(winner[0])
                .as("car4가 우승해야합니다.")
                .isEqualTo(cars.get(2).getName());
    }

    @Test
    @DisplayName("Car객체 생성 시, 5자 이상의 Car 이름 에러 테스트")
    void validateInputNameTest() {
        String[] names = {"avente"};

        assertThatThrownBy(() -> Car.getInstancesByNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이내여야 합니다.");
    }
}
