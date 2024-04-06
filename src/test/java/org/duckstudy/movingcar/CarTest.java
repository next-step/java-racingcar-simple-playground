package org.duckstudy.movingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("움직이는 자동차 테스트")
class CarTest {
    private final Car car = new Car("Test car");

    private final Random random = new Random();

    @AfterEach
    void tearDown() {
        car.reset();
    }

    @Nested
    @DisplayName("움직이는 자동차 테스트")
    class CarMoveTest {
        @Test
        @DisplayName("random 값이 4 이상일 경우 1만큼 전진한다")
        void testCarMove() {
            // given
            int randomValue = 4 + random.nextInt(5);

            // when
            long distance = car.move(randomValue);

            // then
            assertThat(distance).isEqualTo(1L);
        }

        @Test
        @DisplayName("random 값이 3 이하인 경우 멈춘다")
        void testCarStop() {
            // given
            int randomValue = random.nextInt(3);

            // when
            long distance = car.move(randomValue);

            // then
            assertThat(distance).isEqualTo(0);
        }
    }

}
