import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("자동차 이름이 중복되면 예외 발생 테스트")
    void 이름이_중복되면_예외_발생() {
        List<String> carNames = List.of(
                "AAA", "BBB", "AAA"
        );
        String throwMessage = "자동차 이름은 중복될 수 없습니다.";

        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(throwMessage);
    }

    @Test
    @DisplayName("중복 없는 이름으로 생성 성공 테스트")
    void 중복_없으면_생성_성공() {
        List<String> carNames = List.of(
                "AAA", "BBB", "CCC"
        );
        int expectedCarSize = 3;

        Cars cars = Cars.from(carNames);

        assertThat(cars.getCars()).hasSize(expectedCarSize);
    }
}
