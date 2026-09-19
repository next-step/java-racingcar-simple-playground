import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Car;
import domain.Cars;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void carNameLengthTest() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @DisplayName("자동차 이름이 null, 빈 문자열, 또는 공백이면 예외가 발생한다")
    void blankCarNameTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다");
    }

    @Test
    @DisplayName("3 이하면 전진, 4 이상이면 움직인다.")
    void moveTest() {

        Cars cars = new Cars(List.of("A", "B"));

        cars.moveAll(new FixNumberGenerator(new int[]{3, 4}));

        List<String> winners = cars.getWinner();

        assertThat(winners).hasSize(1);
        assertThat(winners).isEqualTo(List.of("B"));
    }
}
