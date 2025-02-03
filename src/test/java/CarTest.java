import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("움직이는 자동차 테스트 클래스")
public class CarTest {
    private Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car("Kim");
    }
    @Test
    @DisplayName("자동차 객체 생성이 제대로 되었는가")
    public void testCreateCar() {
        assertThat(car.getName()).isEqualTo("Kim");
        assertThat(car.getPos()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 정상적으로 전진하는가")
    public void testMoveCar() {
        car.move(4);

        assertThat(car.getPos()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 정상적으로 정지하는가")
    public void testStopCar() {
        car.move(3);

        assertThat(car.getPos()).isEqualTo(0);
    }
}
