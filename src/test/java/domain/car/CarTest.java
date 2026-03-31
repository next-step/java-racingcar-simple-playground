package domain.car;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @DisplayName("자동차는 이름을 가지고 있다.")
    @Test
    void testCarName() {
        //given
        String name = "car1";
        Car car = new Car(name);

        //when
        String CarName = car.getName();

        //then
        assertThat(CarName).isEqualTo(name);

    }

    @DisplayName("자동차는 움직일 수 있다.")
    @Test
    void testCarMoving() {
        //given
        String name = "car1";
        Car car = new Car(name);

        //when
        car.moveCar(4);
        int position = car.getPosition();

        //then
        assertThat(position).isEqualTo(1);
    }

    @DisplayName("자동차는 여러번 움직일 수 있다.")
    @Test
    void testCarMovingLot() {
        //given
        String name = "car1";
        Car car = new Car(name);

        //when
        car.moveCar(4);
        car.moveCar(3);
        car.moveCar(8);
        car.moveCar(6);
        int position = car.getPosition();

        //then
        assertThat(position).isEqualTo(3);
    }

    @DisplayName("자동차는 0~9 사이 랜덤한 값으로 움직인다.(0미만)")
    @Test
    void testCarMovingRangeDown() {
        //given
        String name = "car1";
        Car car = new Car(name);

        //when & then
        assertThatThrownBy(() -> car.moveCar(-1))
                .hasMessageContaining("자동차 이동 인자가 0보다 작습니다.");
    }

    @DisplayName("자동차는 0~9 사이 랜덤한 값으로 움직인다.(9초과)")
    @Test
    void testCarMovingRangeUp() {
        //given
        String name = "car1";
        Car car = new Car(name);

        //then
        assertThatThrownBy(() -> car.moveCar(10))
                .hasMessageContaining("자동차 이동 인자가 9보다 큽니다.");
    }
}
