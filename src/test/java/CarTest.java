import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void moveAvailable() {
        Car car = new Car("car");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void moveUnavailable() {
        Car car = new Car("car");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
