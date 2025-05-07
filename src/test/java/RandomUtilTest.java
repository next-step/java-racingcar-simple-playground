import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {
    @RepeatedTest(1000)
    @DisplayName("randomGenerator는 항상 0 이상 9 이하의 값을 반환한다")
    void check_randomGenerator_random_number() {
        int value = RandomUtil.randomGenerator();
        assertThat(value).isGreaterThanOrEqualTo(0).isLessThan(10); // 0 <= value < 10
    }
}