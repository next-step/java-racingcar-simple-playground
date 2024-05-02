import domain.Car;
import domain.Race;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class carMoveTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("random 값이 4 이상일 경우 전진")
    void carMoveForward(int value) {
        Car car = new Car();

        car.check(value, car);

        // 전진했으면 통과
        Assertions.assertThat(car.getCurrentLocation())
                .isEqualTo(1);

    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("random 값이 3 이하의 값이면 멈춘다")
    void carStop(int value) {
        Car car = new Car();
        Race race = new Race();

        car.check(value, car);

        // 정지 통과
        Assertions.assertThat(car.getCurrentLocation())
                .isEqualTo(0);

    }

    @Test
    @DisplayName("random 값 범위 확인")
    void checkRandom() {
        Race race = new Race();

        for (int i = 0; i < 100; i++) {
            int randomNum = race.getRandNum();

            Assertions.assertThat(randomNum).isBetween(0, 9)
                    .isBetween(0, 9);
        }
    }


    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("전진, 정지 메서드 확인")
    void checkRace(int value) {
        Car car = new Car();

        car.check(value, car);

        if (value == 3) {
            Assertions.assertThat(car.getCurrentLocation())
                    .isEqualTo(0);

            return;
        }

        Assertions.assertThat(car.getCurrentLocation())
                .isEqualTo(1);

    }
}