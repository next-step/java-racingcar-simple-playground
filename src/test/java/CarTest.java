import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;

class CarTest {
    @Test
    @DisplayName("전진 조건이 참이면 위치가 증가한다.")
    void increasePositionWhenMovable() {
        Car car = new Car("실험용1");
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
