import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("4이상의 숫자가 나왔을 경우 이동함")
    void go() {
        Car car = new Car("neo");
        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("3이하의 숫자가 나왔을 경우, 멈춤")
    void stop() {
        Car car = new Car("neo");
        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름이 5글자 이상일 경우 오류 발생")
    void name_error() {
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("toolong"));
    }
}
