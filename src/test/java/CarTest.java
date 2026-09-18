import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void 값이_4_이상이면_자동차가_전진한다() {
        Car car = new Car("car");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 값이_4보다_작으면_자동차가_전진하지_않는다() {
        Car car = new Car("car");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 자동차_이름은_5자까지_가능하다() {
        // given
        String name = "car12";

        // when, then
        assertThatCode(() -> new Car(name))
                .doesNotThrowAnyException();
    }

    @Test
    public void 자동차_이름이_5자를_넘으면_예외가_발생한다() {
        // given
        String name = "car123";

        // when, then
        assertThatCode(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }
}
