import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    @Test
    @DisplayName("자동차 이름 경계값 검증 테스트")
    void 자동차_이름_경계값_검증() {
        assertAll(
                () -> assertThatCode(() -> new Car("pobi"))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new Car("12345"))
                        .doesNotThrowAnyException(),
                () -> assertThatThrownBy(() -> new Car("123456"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.")
        );
    }

    @Test
    @DisplayName("무작위 값이 4 이상일 경우 자동차는 한 칸 전진한다.")
    void 자동차_전진_성공() {
        Car car = new Car("pobi");
        NumberGenerator alwaysMoveGenerator = () -> 4;

        car.move(alwaysMoveGenerator);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("무작위 값이 3 이하일 경우 자동차는 정지한다.")
    void 자동차_정지_성공() {
        Car car = new Car("crong");
        NumberGenerator alwaysStopGenerator = () -> 3;

        car.move(alwaysStopGenerator);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}