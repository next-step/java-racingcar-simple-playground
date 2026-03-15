package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int MOVABLE_NUMBER = 4;
    private static final int NON_MOVABLE_NUMBER = 3;

    @Test
    @DisplayName("자동차 앞으로 이동: 이동 조건이 성립할 경우, 위치는 계속해서 1 증가.")
    void move_Forward() {
        //given
        Car car = new Car("Red");
        //when
        car.moveForward(() -> MOVABLE_NUMBER);
        car.moveForward(() -> MOVABLE_NUMBER);
        car.moveForward(() -> MOVABLE_NUMBER);
        car.moveForward(() -> MOVABLE_NUMBER);
        //then
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차 정지: 이동 조건이 성립하지 않을 경우, 위치는 변화 없음.")
    void move_Stop() {
        //given
        Car car = new Car("Red");
        //when
        car.moveForward(() -> NON_MOVABLE_NUMBER);
        car.moveForward(() -> NON_MOVABLE_NUMBER);
        car.moveForward(() -> NON_MOVABLE_NUMBER);
        car.moveForward(() -> NON_MOVABLE_NUMBER);
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}