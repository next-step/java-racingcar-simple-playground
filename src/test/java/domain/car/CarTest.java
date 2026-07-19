package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("이동 조건을 만족하면 자동차가 한 칸 전진한다")
    void move_forward_when_move_condition_is_true() {
        Car car = new Car("white", 0, number -> true);

        car.moveCar(0);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 조건을 만족하지 않으면 자동차가 전진하지 않는다")
    void stop_when_move_condition_is_false() {
        Car car = new Car("white", 0, number -> false);

        car.moveCar(0);

        assertThat(car.getLocation()).isZero();
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하이면 자동차를 생성한다")
    void create_car_when_name_is_five_characters_or_less() {
        Car car = new Car("white", 2);

        assertThat(car.getName()).isEqualTo("white");
        assertThat(car.getLocation()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void throw_exception_when_name_is_over_five_characters() {
        assertThatThrownBy(() -> new Car("chorok", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
