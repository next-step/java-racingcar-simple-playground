import domain.Car;
import java.util.Random;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤값이 4 이상일 때 자동차가 전진하는지 확인하는 테스트")
    void testCarMovesWhenRandomValueIsAboveThreshold() {
        MockRandom mockRandom = new MockRandom(4);
        Car car = new Car("테스트카", mockRandom);
        int initialPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Test
    @DisplayName("랜덤값이 3 이하일 때 자동차가 멈추는지 확인하는 테스트")
    void testCarStopsWhenRandomValueIsBelowThreshold() {
        MockRandom mockRandom = new MockRandom(3);
        Car car = new Car("테스트카", mockRandom);
        int initialPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }

    @Test
    @DisplayName("자동차 이름이 올바르게 설정되는지 확인하는 테스트")
    void testCarName() {
        Car car = new Car("내차");

        assertThat(car.getName()).isEqualTo("내차");
    }

    @Test
    @DisplayName("자동차의 초기 위치가 0인지 확인하는 테스트")
    void testInitialPosition() {
        Car car = new Car("테스트카");

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤값 경계값 테스트")
    void testRandomBoundaryValues() {
        MockRandom boundaryRandom = new MockRandom(4);
        Car car = new Car("경계테스트", boundaryRandom);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);

        MockRandom lowerBoundaryRandom = new MockRandom(3);
        Car car2 = new Car("경계테스트2", lowerBoundaryRandom);

        car2.move();

        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("여러 번 이동해도 정상 동작하는지 확인하는 테스트")
    void testMultipleMoves() {
        MockRandom alwaysMove = new MockRandom(5);
        Car car = new Car("연속이동", alwaysMove);

        for (int i = 0; i < 5; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("극값 랜덤 테스트 - 최대값 9일 때")
    void testMaxRandomValue() {
        MockRandom maxRandom = new MockRandom(9);
        Car car = new Car("최대값테스트", maxRandom);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("극값 랜덤 테스트 - 최소값 0일 때")
    void testMinRandomValue() {
        MockRandom minRandom = new MockRandom(0);
        Car car = new Car("최소값테스트", minRandom);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    private static class MockRandom extends Random {
        private final int fixedValue;

        public MockRandom(int fixedValue) {
            this.fixedValue = fixedValue;
        }

        @Override
        public int nextInt(int bound) {
            return fixedValue;
        }
    }
}
