import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 움직이기")
    void moveCarTest() {
        Car a = new Car("a");
        assertThat(a.moveCar()).isGreaterThanOrEqualTo(0);
    }

}
