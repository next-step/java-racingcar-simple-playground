package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;


@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    void 이름을_갖는다() {
        Environment environment = new Environment(new ObstaclesAhead.ByRandom(0));
        Car car = new Car(environment, new Car.Name("neo"));

        assertThat(car.name).isEqualTo(new Car.Name("neo"));
    }

    @Test
    void 이름의_길이은_5글자_이하이다() {
        assertThatCode(() -> new Car.Name("1234")).doesNotThrowAnyException();
        assertThatCode(() -> new Car.Name("12345")).doesNotThrowAnyException();
        assertThatThrownBy(() -> new Car.Name("123456")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car.Name("1234567")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 앞으로_움직일_수_있다() {
        Environment environment = new Environment(new ObstaclesAhead.ByRandom(0));
        Car car = new Car(environment, new Car.Name("brie"));

        for (int i = 0; i < 5; i++) {
            car.tryAdvance();
        }

        assertThat(car.getPosition()).isGreaterThan(0);
    }

    @Test
    void 장애물을_피하면_한칸_이동한다() {
        Environment environment = new Environment(new TestObstacles());
        Car car = new Car(environment, new Car.Name("brown"));

        for (int i = 0; i < TestObstacles.RESULTS.length; i++) {
            car.tryAdvance();
        }

        assertThat(car.getPosition()).isEqualTo(TestObstacles.AVOIDED_RESULT_COUNT);
    }
}
