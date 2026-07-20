import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차는_이름을_가진다() {
        Car car = new Car("seoyeon");

        assertThat(car.getName()).isEqualTo("seoyeon");
    }

    @Test
    void 숫자가_4_이상이면_전진한다() {
        Car car = new Car("seoyeon");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 숫자가_3_이하이면_정지한다() {
        Car car = new Car("seoyeon");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);

    }
}
