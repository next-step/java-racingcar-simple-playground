package org.duckstudy.model.generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 값 생성 테스트")
class RandomValueGeneratorTest {
    @Test
    @DisplayName("0 이상 9 이하의 랜덤 값을 생성한다")
    void generateValue() {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

        int value = randomValueGenerator.generateValue();

        assertThat(value).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
