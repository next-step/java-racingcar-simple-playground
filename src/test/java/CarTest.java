import domain.Car;
import domain.NumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    static class TestNumberGenerator implements NumberGenerator {
        private final int number;

        public TestNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int getNumber(){
            return number;
        }
    }

    /*
     * 경계값 테스트 => 0, 3, 4, 9
     * */
    @Test
    void 랜덤값_0일때_멈춤() {
        // Given(준비)
        NumberGenerator testNumberGenerator = new TestNumberGenerator(0);
        Car car = new Car("car", testNumberGenerator);
        // When(실행)
        car.move();
        // Then(검증)
        assertEquals(0, car.getTotalDistance());
    }
    @Test
    void 랜덤값_3일때_멈춤() {
        // Given(준비)
        NumberGenerator testNumberGenerator = new TestNumberGenerator(3);
        Car car = new Car("car", testNumberGenerator);
        // When(실행)
        car.move();
        // Then(검증)
        assertEquals(0, car.getTotalDistance());
    }
    @Test
    void 랜덤값_4일때_전진() {
        // Given(준비)
        NumberGenerator testNumberGenerator = new TestNumberGenerator(4);
        Car car = new Car("car", testNumberGenerator);

        // When(실행)
        car.move();
        // Then(검증)
        assertEquals(1, car.getTotalDistance());
    }
    @Test
    void 랜덤값_9일때_전진() {
        // Given(준비)
        NumberGenerator testNumberGenerator = new TestNumberGenerator(9);
        Car car = new Car("car", testNumberGenerator);
        // When(실행)
        car.move();
        // Then(검증)
        assertEquals(1, car.getTotalDistance()); // 주의) 각 테스트는 독립적으로 실행되므로 예상값은 2가 아닌 1
    }

    /*
    * 이름 길이 검증 로직 테스트
    * */
    @Test
    void 이름이_5글자_이하인_경우() {
        //Given
        NumberGenerator testNumberGenerator = new TestNumberGenerator(0);

        //When & Then
        assertDoesNotThrow(() -> new Car("12345", testNumberGenerator));
    }
    @Test
    void 이름이_5글자_초과인_경우() {
        //Given
        NumberGenerator testNumberGenerator = new TestNumberGenerator(0);

        //When & Then
        assertThrows(IllegalArgumentException.class, ()
                -> new Car("123456", testNumberGenerator));
    }
}