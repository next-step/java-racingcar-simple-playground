import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {
    Random random = new Random();

    @Test
    void 자동차_이동_테스트() {
        // given
        Car car = new Car("TestCar", random);
        int initial = car.getLocation();

        // when
        car.move();

        // then
        assertThat(car.getLocation()).isGreaterThanOrEqualTo(initial);
    }

    @Test
    @DisplayName("2대 이상의 자동차만 경주 시작가능")
    void 레이스_생성_테스트1() {
        // given
        Car porsche = new Car("포르쉐", random);
        List<Car> cars1 = Arrays.asList(porsche);

        // when, then
        assertThatThrownBy(() -> Race.createRace(cars1, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("두 대이상의 차를 입력해주세요.");
    }

    @Test
    @DisplayName("시도횟수 1회 이상만 경주 시작 가능")
    void 레이스_생성_테스트2() {
        // given
        Car car1 = new Car("Test1", random);
        Car car2 = new Car("Test2", random);
        List<Car> cars = Arrays.asList(car1, car2);

        // when,then
        assertThatThrownBy(() -> Race.createRace(cars, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1번 이상의 시도횟수를 입력해주세요.");
    }

    @Test
    void 레이스_우승자_고르기() {
        // given
        Car car1 = new Car("Car1", random);
        Car car2 = new Car("Car2", random);
        List<Car> cars = Arrays.asList(car1, car2);
        Race race = Race.createRace(cars, 5);

        // when
        race.start();

        // then
        List<String> winners = race.getWinner();
        assertThat(winners).isNotEmpty();
    }
}
