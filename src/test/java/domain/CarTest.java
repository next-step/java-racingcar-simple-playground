package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("차 이동 테스트: 전진")
    void checkMove() {
        // Given
        Car car = new Car("aaa");
        int moveNumber = 4;

        // When
        car.tryMoveByNumber(moveNumber);

        // Then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("차 이동 테스트 - 전진X")
    void checkNotMove() {
        // Given
        Car car = new Car("aaa");
        int notMoveNumber = 1;

        // When
        car.tryMoveByNumber(notMoveNumber);

        // Then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Nested
    @DisplayName("자동차 생성 - 이름 테스트")
    class InvalidCarNameTest {
        @Test
        @DisplayName("자동차 생성 이름 테스트: 예외")
        void invalidCarNameTest() {
            assertAll(
                () -> assertThatThrownBy(() -> new Car("aaaaaa")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Car("  ")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("자동차 생성 이름 테스트: 정상")
        void validCarName() {
            assertDoesNotThrow(()->new Car("aaa"));
        }
    }

}
