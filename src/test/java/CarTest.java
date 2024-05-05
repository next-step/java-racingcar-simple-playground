import static org.assertj.core.api.Assertions.assertThat;

import decider.StaticPositionDecider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("3이하의 숫자는 자동차가 움직일 수 없다.")
    void canNotMoveLessThan3(int value) {
        final Car car = new Car("K5", new StaticPositionDecider(value));
        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4에서 9 이하의 숫자는 자동차가 움직일 수 있다.")
    void canMoveBetween4And9(int value) {
        final Car car = new Car("K5", new StaticPositionDecider(value));
        car.move();

        assertThat(car.getPosition()).isGreaterThanOrEqualTo(1);
    }
}
