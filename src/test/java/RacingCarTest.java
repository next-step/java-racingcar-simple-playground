import java.util.Random;

import domain.RacingCar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("움직이는 자동차 테스트")
class RacingCarTest {
    private static final String TEST_CAR_NAME = "TestCar";

    // 고정된 난수 값을 반환하는 MockRandom 클래스 (Random 상속)
    private static class MockRandom extends Random {
        private final int mockedValue;

        public MockRandom(int mockedValue) {
            this.mockedValue = mockedValue;
        }

        @Override
        public int nextInt(int bound) {
            return mockedValue;
        }
    }

    private RacingCar carWithMockRandom(int mockedValue) {
        return new RacingCar(TEST_CAR_NAME, new MockRandom(mockedValue));
    }

    @DisplayName("랜덤값이 4 이상일 경우, 항상 전진하는가?")
    @Test
    void moveWhenValueIsAtLeast4() {
        int[] testValues = {4, 5, 6, 7, 8, 9}; // 전진해야 하는 테스트 값

        for (int mockedValue : testValues) {
            RacingCar car = carWithMockRandom(mockedValue);
            boolean isMoved = car.move();

            assertThat(isMoved)
                    .as("랜덤 값이 %d일 때 자동차가 전진해야 합니다.", mockedValue)
                    .isTrue();
        }
    }

    @DisplayName("랜덤값이 3 이하일 경우, 항상 정지하는가?")
    @Test
    void stopWhenValueIsLessThan4() {
        int[] testValues = {0, 1, 2, 3}; // 정지해야 하는 테스트 값

        for (int mockedValue : testValues) {
            RacingCar car = carWithMockRandom(mockedValue);
            boolean isMoved = car.move();

            assertThat(isMoved)
                    .as("랜덤 값이 %d일 때 자동차가 정지해야 합니다.", mockedValue)
                    .isFalse();
        }
    }
}
