package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
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
}
