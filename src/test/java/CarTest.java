import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Car;

public class CarTest {

    private final Car car = new Car("test");

    @Test
    @DisplayName("자동차 이름을 반환한다.")
    public void getName() {
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("랜덤 수가 4 이상이다: 자동차를 움직인다.")
    public void move() {
        car.move(5);
        assertTrue(car.getPosition() == 1);
    }

    @Test
    @DisplayName("랜덤 수가 4 이하이다: 자동차는 움직이지 않는다.")
    public void dontMove() {
        car.move(2);
        assertTrue(car.getPosition() == 0);
    }
}
