import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Cars;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @Test
    @DisplayName("자동차 목록에 중복된 이름이 존재하면 예외가 발생한다")
    void duplicateCarNamesTest() {
        List<String> duplicatedNames = List.of("pobi", "crong", "pobi");

        assertThatThrownBy(() -> new Cars(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다");
    }

    @Test
    @DisplayName("공백을 제거했을 때 중복되는 이름이 존재하면 예외가 발생한다")
    void duplicateCarNamesWithSpaceTest() {
        List<String> duplicatedNames = List.of("pobi", " crong", "crong ");

        assertThatThrownBy(() -> new Cars(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다");
    }

    @Test
    @DisplayName("자동차 수가 2대 미만이면 예외가 발생한다")
    void minimumCarCountTest() {
        List<String> singleCar = List.of("pobi");

        assertThatThrownBy(() -> new Cars(singleCar))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 2대 이상");
    }
}
