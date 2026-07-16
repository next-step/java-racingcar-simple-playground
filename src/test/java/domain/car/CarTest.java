package domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void random값이_4이상이면_position값이_증가한다() {
        Car car = new Car("test1");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void random값이_3이하면_position값은_변하지_않는다() {
        Car car = new Car("test1");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void random값이_0미만이면_예외를_던진다() {
        Car car = new Car("test1");

        assertThatThrownBy(() -> car.move(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void random값이_9초과면_예외를_던진다() {
        Car car = new Car("test1");

        assertThatThrownBy(() -> car.move(10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진_조건과_정지_조건이_섞이면_전진한_횟수만큼만_position값이_증가한다() {
        Car car = new Car("test1");

        car.move(4);
        car.move(2);
        car.move(8);
        car.move(1);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 자동차의_이름이_5자를_초과하면_예외를_던진다() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름이_빈_이름이라면_예외를_던진다() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
