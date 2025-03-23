import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import CarGame2.domain.service.RandomGenerator;

public class RandomGeneratorTest {

    private final RandomGenerator generator = new RandomGenerator();

    @Test
    @DisplayName("랜덤 생성값이 0에서 9 사이인지 확인")
    void 랜덤값_범위_테스트() {
        for (int i = 0; i < 100; i++) {
            int value = generator.NumberGenerate();
            assertThat(value).isBetween(0, 9);
        }
    }
}
