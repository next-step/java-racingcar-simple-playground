import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차는 4이상의 값이 입력되면 전진한다.(position을 1 증가 시킨다.)")
    void moveForward() {
        // given
        Car car = new Car("이름");

        // when
        car.moveForward(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차와 동일한 포지션을 입력하면 true를 반환한다.")
    void isSamePosition() {
        // given
        Car car = new Car("이름");
        car.moveForward(4);
        car.moveForward(4);

        // when
        boolean samePosition = car.isSamePosition(2);

        // then
        assertThat(samePosition).isTrue();
    }
}
