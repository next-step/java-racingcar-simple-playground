import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차가 움직이거나 정차하는지 테스트 한다.")
    void testMove() {
        // Given
        Car car = new Car("TestCar");

        // When
        car.move();

        // Then
        assertThat(car.getNumberOfMoves()).isIn(0, 1);
    }
}
