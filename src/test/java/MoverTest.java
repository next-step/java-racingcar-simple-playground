import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoverTest{

    @Test
    @DisplayName("4 이상의 숫자가 나올 경우 전진")
    void return_1() {
        Car car = new Car("neo");

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("3 이하의 숫자가 나올 경우 정지")
    void return_0() {
        Car car = new Car("neo");

        car.move(2);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
