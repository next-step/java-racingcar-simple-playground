import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @DisplayName("랜덤값 4 이상 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_forward_when_number_is_four_or_more(int randomNumber) {
        Car car = new Car("white", 0);

        car.moveCar(randomNumber);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤값 3 이하 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    void stop_when_number_is_three_or_less(int randomNumber) {
        Car car = new Car("white", 0);

        car.moveCar(randomNumber);

        assertThat(car.getLocation()).isZero();
    }

    @Test
    @DisplayName("자동차 이름 5자 이하 테스트")
    void create_car_when_name_is_five_characters_or_less() {
        Car car = new Car("white", 2);

        assertThat(car.getName()).isEqualTo("white");
        assertThat(car.getLocation()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 테스트")
    void throw_exception_when_name_is_over_five_characters() {
        assertThatThrownBy(() -> new Car("chorok", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
