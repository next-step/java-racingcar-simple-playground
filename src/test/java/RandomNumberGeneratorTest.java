import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("발생된 무작위 수는 0~9 사이의 수이다.(0,9 포함)")
    void RandomNumberRangeIs0to9() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertThat(numberGenerator.generateNumber())
                .isBetween(0, 9);
    }
}
