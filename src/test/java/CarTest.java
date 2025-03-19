import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import CarGame2.Car;
import CarGame2.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차가 정상적으로 생성되고 이름이 저장되는지 테스트")
    void 자동차_생성_및_이름_저장() {
        Car car = new Car("car1", () -> 5);
        assertThat(car.getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("자동차 이름이 null이면 예외 발생")
    void 자동차_이름_null_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null, () -> 5));
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외 발생")
    void 자동차_이름_빈문자_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Car(" ", () -> 5));
    }

    @Test
    @DisplayName("자동차 이름길이가 5를 초과하면 예외 발생")
    void 자동차_이름_5_초과_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Car("abcdef", () -> 5));
    }

    @Test
    @DisplayName("자동차는 4이상일 경우에만 전진")
    void 기준_이상일경우_자동차_전진() {
        Generator fixedGenerator = () -> 4;
        Car car = new Car("car1", fixedGenerator);

        car.move();

        assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차는 4미만일 경우에는 정지")
    void 기준_미만일경우_자동차_정지() {
        Generator fixedGenerator = () -> 3;
        Car car = new Car("car1", fixedGenerator);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
