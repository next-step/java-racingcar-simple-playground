import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.SplitCarNames;

import java.util.ArrayList;
import java.util.List;

public class SplitCarNamesTest {

    @Test
    @DisplayName("','로 구별된 자동차 이름을 분리할 수 있다.")
    public void splitCarNamesByComma() {
        //given
        String carNames = "car1,car2,car3";
        List<String> expected = new ArrayList<String>(List.of("car1", "car2", "car3"));

        //when
        List<String> result = SplitCarNames.splitCarNames(carNames);

        //then
        Assertions.assertThat(result).usingRecursiveAssertion().isEqualTo(expected);
        Assertions.assertThat(result).contains("car1");
        Assertions.assertThat(result).contains("car2");
        Assertions.assertThat(result).contains("car3");
    }
}
