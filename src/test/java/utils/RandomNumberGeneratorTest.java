package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("난수 생성 테스트")
public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자는 0이상 10미만(0~9)이다")
    void randomNumberGenerator() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        for (int i = 0; i < 100; i++) {
            int num = generator.generate();
            assertThat(num).isBetween(0, 9);
        }
    }

}

