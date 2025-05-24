import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.FixedNumberGenerator;
import utils.RandomNumberGenerator;

@DisplayName("자동차 경주 테스트")
public class RacingGameTest {

    @Test
    @DisplayName("경주에서 우승한 자동차를 가려낸다. (여러 명일 수 있음)")
    void getWinners() {
        Car car1 = new Car("일등", 2);
        Car car2 = new Car("이등", 2);
        Car car3 = new Car("삼등", 1);
        Car car4 = new Car("사등", 0);

        List<Car> cars = List.of(car1, car2, car3, car4);
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator(), cars);

        List<Car> winners = racingGame.getWinners();

        assertThat(winners).containsExactlyInAnyOrder(car1, car2);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("모든 차량이 3라운드 내내 전진")
    void moveForwardAllCars(int generatedNumber) {
        List<Car> cars = Arrays.asList(new Car("a"), new Car("b"), new Car("c"));
        RacingGame racingGame = new RacingGame(new FixedNumberGenerator(generatedNumber), cars);

        for (int i = 0; i < 3; i++) {
            racingGame.moveForward();
        }

        cars.forEach(car -> assertThat(car.getDistance()).isEqualTo(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("모든 차량이 3라운드 내내 정지")
    void playAllCarsStops(int generatedNumber) {
        List<Car> cars = Arrays.asList(new Car("a"), new Car("b"), new Car("c"));
        RacingGame racingGame = new RacingGame(new FixedNumberGenerator(generatedNumber), cars);

        for (int i = 0; i < 3; i++) {
            racingGame.moveForward();
        }

        cars.forEach(car -> assertThat(car.getDistance()).isEqualTo(0));
    }
}
