import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진한다")
    void moveWhenRandomNumberIsFourOrMore() {
        Car car = new Car("greenCar");

        car.moveCar(4);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 3 이하이면 정지한다")
    void stopWhenRandomNumberIsThreeOrLess() {
        Car car = new Car("greenCar");

        car.moveCar(3);

        assertThat(car.getLocation()).isZero();
    }
}
