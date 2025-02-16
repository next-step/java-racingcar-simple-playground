package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RandomValueGeneratorTest {

    @Test
    @DisplayName("랜덤값을 생성하면 10 내의 범위에 있는지 검증한다.")
    void testRandomValueGenerator() {
        int randomNumber = RandomValueGenerator.getRandomNumber();

        assertThat(randomNumber).isBetween(0, 10);
    }
}
