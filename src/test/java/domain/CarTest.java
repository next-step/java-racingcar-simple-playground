package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private static Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car("asdf");
    }

    @DisplayName("입력이 4 이상이면 1, 아니면 0을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "3,0", "4,1", "9,1"})
    public void testMoveIfGreaterThan_ValidNumber(final int number, final int expected) {
        // when
        car.moveIfGreaterThan(number);

        // then
        assertThat(car.getMoveHistory().get(0)).isEqualTo(expected);
    }

    @DisplayName("입력이 0보다 작거나 10 이상이면 IllegalArgumentException을 throw한다.")
    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 10, 20})
    public void testMoveIfGreaterThan_InvalidNumber(final int number) {
        // when & then
        assertThatThrownBy(() -> car.moveIfGreaterThan(number)).isInstanceOf(IllegalArgumentException.class).hasMessage("입력값이 범위를 벗어났습니다.");
    }

    @DisplayName("입력이 배열일 경우 각 원소마다 4 이상이면 움직인다.")
    @ParameterizedTest
    @MethodSource
    public void testMoveIfGreaterThan_ValidNumberArray(final int[] numbers, final List<Integer> expected) {
        // when
        car.moveIfGreaterThan(numbers);

        // then
        assertThat(car.getMoveHistory()).isEqualTo(expected);
    }

    private static Stream<Arguments> testMoveIfGreaterThan_ValidNumberArray() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 3, 4, 9}, List.of(0, 0, 1, 1)),
                Arguments.arguments(new int[]{4, 4, 4, 4}, List.of(1, 1, 1, 1)),
                Arguments.arguments(new int[]{3, 3, 3, 3}, List.of(0, 0, 0, 0))
        );
    }
}
