package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    @DisplayName("차랑이 움직이면 거리가 1증가해야한다")
    void 차랑이_움직이면_거리가_1증가해야한다() {
        //given
        Car car = Car.createCar("car");

        //when
        car.move();

        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("차량이 이름이 반환되어야 한다")
    void 차량이_이름이_반환되어야_한다() {
        //given
        Car car = Car.createCar("car");

        //when
        car.move();

        //then
        Assertions.assertThat(car.getName()).isEqualTo("car");
    }

    @Test
    @DisplayName("차량의 이름의 길이는 5이하여야 한다")
    void 차량의_이름의_길이는_5이하여야_한다() {
        //then
        Assertions.assertThatThrownBy(() -> Car.createCar("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차량의 이름은 빌 수 없다")
    void 차량의_이름은_빌_수_없다() {
        //then
        Assertions.assertThatThrownBy(() -> Car.createCar(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}