package domain.strategy;

import domain.car.Car;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarMovementStrategyTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    @DisplayName("주어진 횟수동안 자동차(들)는 전진 또는 멈출 수 있다")
    void can_move_during_given_numbers(int round) {
        //Given
        Car elecCar = new Car("전기차", new AlwaysMoveStrategy(), 0);
        Car oilCar = new Car("기름차", new NeverMoveStrategy(), 0);
        List<Car> cars = List.of(elecCar, oilCar);

        //When
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.move();
            }
        }

        //Then
        Assertions.assertThat(elecCar.getPosition()).isEqualTo(round);
        Assertions.assertThat(oilCar.getPosition()).isZero();
    }
}
