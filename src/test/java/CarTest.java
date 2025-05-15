import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 움직이기")
    void moveCarTest() {
        Car a = new Car("a", new RandInt());
        assertThat(a.moveCar()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진")
    void goCarTest() {
        Car b = new Car("b", new FixedInt(6));
        assertThat(b.moveCar()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 정지")
    void stopCarTest() {
        Car b = new Car("b", new FixedInt(2));
        assertThat(b.moveCar()).isEqualTo(0);
    }

}
