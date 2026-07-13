import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 경계값 테스트 => 0, 3, 4, 9

class CarTest {

    @Test
    void 랜덤값_0일때_멈춤() {
        // Given(준비)
        Car car = new Car();
        // When(실행)
        car.move(0);
        // Then(검증)
        assertEquals(0, car.getTotalDistance());
    }
    @Test
    void 랜덤값_3일때_멈춤() {
        // Given(준비)
        Car car = new Car();
        // When(실행)
        car.move(3);
        // Then(검증)
        assertEquals(0, car.getTotalDistance());
    }
    @Test
    void 랜덤값_4일때_전진() {
        // Given(준비)
        Car car = new Car();
        // When(실행)
        car.move(4);
        // Then(검증)
        assertEquals(1, car.getTotalDistance());
    }
    @Test
    void 랜덤값_9일때_전진() {
        // Given(준비)
        Car car = new Car();
        // When(실행)
        car.move(9);
        // Then(검증)
        assertEquals(1, car.getTotalDistance()); // 주의) 각 테스트는 독립적으로 실행되므로 예상값은 2가 아닌 1
    }
}