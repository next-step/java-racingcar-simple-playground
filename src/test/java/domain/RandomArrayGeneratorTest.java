package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomArrayGeneratorTest {
    private static RandomArrayGenerator randomArrayGenerator;

    @BeforeAll
    public static void beforeAll() {
        randomArrayGenerator = new RandomArrayGenerator();
    }

    @DisplayName("length를 입력받아 길이가 length인 랜덤 정수 배열을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 30})
    public void testGenerateRandomArray_ValidLength(final int expected) {
        // when
        final int actual = randomArrayGenerator.generateRandomArray(expected).length;

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("length가 0 이하라면 IllegalArgumentException을 throw한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    public void testGenerateRandomArray_InvalidLength(final int length) {
        // when & then
        assertThatThrownBy(() -> randomArrayGenerator.generateRandomArray(length)).isInstanceOf(IllegalArgumentException.class).hasMessage("배열의 길이는 0 이하일 수 없습니다.");
    }

    @DisplayName("length1, length2를 입력받아 크기가 [length1][length2]인 2차원 랜덤 정수 배열을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "1,5", "5,1", "4,5"})
    public void testGenerateRandom2DArray_ValidLengths(final int length1, final int length2) {
        // when
        final int[][] actual = randomArrayGenerator.generateRandom2DArray(length1, length2);

        // then
        assertThat(actual).hasDimensions(length1, length2);
    }

    @DisplayName("입력받은 길이 중 0 이하인 것이 있다면 IllegalArgumentException을 throw한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,5", "5,0", "0,0", "-5,5", "5,-5", "-5,-5", "0,-5", "-5,0"})
    public void testGenerateRandom2DArray_InvalidLengths(final int length1, final int length2) {
        // when & then
        assertThatThrownBy(() -> randomArrayGenerator.generateRandom2DArray(length1, length2)).isInstanceOf(IllegalArgumentException.class).hasMessage("배열의 길이는 0 이하일 수 없습니다.");
    }
}
