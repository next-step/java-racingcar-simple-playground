import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 전진조건이_참이면_위치가_증가한다() {
        Car car = new Car("실험용1");
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}