package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class RacingCarTest {
    @Test
    @DisplayName("racing car move test success")
    public void moveTest() {
        RacingCar car = new RacingCar("test");
        car.move(true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("racing car move test fail")
    public void moveTest2() {
        RacingCar car = new RacingCar("test");
        car.move(false);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("name exception test")
    public void nameLengthExceptionTest() {
        assertThatThrownBy(() -> new RacingCar("toolongname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다");
    }
}
