import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("숫자가 4이상이면 자동자의 position 값이 1 증가한다.")
    @Test
    void move_car_if_number_more_4() {
        // given
        final Car car = new Car("안석환", new AlwaysMoveStrategy());

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("숫자가 3이하이면 자동차의 position 값이 변하지 않는다")
    @Test
    void can_not_move_car_if_number_blow_3() {
        // given
        final Car car = new Car("안석환", new AlwaysNotMoveStrategy());

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
