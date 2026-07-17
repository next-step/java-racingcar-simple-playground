package domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤값 0~9 생성 테스트")
    void generate_number_between_zero_and_nine() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();

        for (int count = 0; count < 100; count++) {
            assertThat(numberGenerator.getNumber()).isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("랜덤값 범위 초과 테스트")
    void throw_exception_when_generated_number_is_over_nine() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator(new FixedRandom(10));

        assertThatThrownBy(numberGenerator::getNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤값 범위 미만 테스트")
    void throw_exception_when_generated_number_is_less_than_zero() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator(new FixedRandom(-1));

        assertThatThrownBy(numberGenerator::getNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static class FixedRandom extends Random {
        private final int number;

        private FixedRandom(int number) {
            this.number = number;
        }

        @Override
        public int nextInt(int bound) {
            return number;
        }
    }
}
