import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 전진조건이_참이면_위치가_증가한다() {
        Car car = new Car("실험용1");
        AlwaysMovable alwaysMovable = new AlwaysMovable();

        car.move(alwaysMovable.isMovable());

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 전진조건이_거짓이면_위치가_증가하지않는다() {
        Car car = new Car("실험용2");
        NeverMovable neverMovable = new NeverMovable();

        car.move(neverMovable.isMovable());

        assertThat(car.getPosition()).isEqualTo(0);
    }
}