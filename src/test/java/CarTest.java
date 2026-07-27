import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("움직이는 기능이 의도대로 동작하는지 테스트")
    void moveTest() {
        Car car = new Car("test");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("멈추는 기능이 의도대로 동작하는지 테스트")
    void stopTest() {
        Car car = new Car("test");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
