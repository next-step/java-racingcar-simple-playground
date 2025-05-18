package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarNameParserTest {

    @Nested
    @DisplayName("입력된 문자열은 구분자로 나누어 차의 이름이 된다.")
    class ParseCarNameTest {

        @Test
        @DisplayName("공백없이 들어왔을 경우")
        public void parseCarName_문자열을입력하면_차이름리스트가생성된다() {

            // given
            String carNames = "차1,차2,차3";

            // when
            List<Car> cars = CarNameParser.parseCarName(carNames);

            // then
            assertThat(cars).extracting(Car::getName).containsExactly("차1", "차2", "차3");

        }

        @Test
        @DisplayName("공백 포함해 들어왔을 경우")
        public void parseCarName_구분자기준으로공백이포함된경우_공백제거후차이름리스트가생성된다() {

            // given
            String carNames = "차1  , 차2,차3  ";

            // when
            List<Car> cars = CarNameParser.parseCarName(carNames);

            // then
            assertThat(cars).extracting(Car::getName).containsExactly("차1", "차2", "차3");

        }
    }

    @Test
    @DisplayName("입력된 차들의 이름은 중복이 없어야 한다.")
    public void parseCarName_중복된차이름_예외처리() {
        // given
        CarNameParser carNameParser = new CarNameParser();
        String carNames = "차1,차1,차3";

        assertThatThrownBy(() -> carNameParser.parseCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름은 입력할 수 없습니다.");
    }
}
