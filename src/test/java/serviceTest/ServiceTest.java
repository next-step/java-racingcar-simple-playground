package serviceTest;

import domain.Car;
import global.RandomUtil;
import global.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.RacingGameService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {
    @Test
    @DisplayName("가장 높은 moveDistance 반환 테스트")
    void getLongestMoveDistanceTest() {
        RacingGameService racingGameService = new RacingGameService();
        List<Car> cars = new ArrayList<>();

        for (int i = 3; i < 6; i++) {
            RandomUtil testNumberGenerator = new TestNumberGenerator(i);
            Car car = new Car("car" + i, testNumberGenerator);
            car.moveForwardOrStay();
            cars.add(car);
        }

        int longestMoveDistance = racingGameService.getLongestMoveDistance(cars);

        assertThat(longestMoveDistance)
                .as("longestMoveDistance값이 기대값과 일치하지 않습니다.")
                .isEqualTo(2);
    }

    @Test
    @DisplayName("moveDistance가 높은 Cars 우승 테스트")
    void getWinnerTest() {
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
    @DisplayName("시도횟수만큼 Cars의 움직임 Test")
    void moveCarsTest() {
        int testCount = 3;
        List<Car> cars = new ArrayList<>();
        RacingGameService racingGameService = new RacingGameService();

        for (int i = 4; i < 7; i++) {
            RandomUtil testNumberGenerator = new TestNumberGenerator(i);
            Car car = new Car("car" + i, testNumberGenerator);
            cars.add(car);
        }

        for (int i = 0; i < testCount; i++) {
            racingGameService.moveCars(cars);
        }

        assertThat(racingGameService.getLongestMoveDistance(cars)).as("cars가 시도횟수 만큼 움직이지 않았습니다.").isEqualTo(4);
    }
}
