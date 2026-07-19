import domain.Car;
import domain.NumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 랜덤값_0과_3일때_멈춤(int ranVal) {
        // Given(준비)
        NumberGenerator testNumberGenerator = new TestNumberGenerator(ranVal);
        Car car = new Car("car", testNumberGenerator);
        // When(실행)
        car.move();
        // Then(검증)
        assertEquals(0, car.getTotalDistance());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 랜덤값_4와_9일때_전진(int ranVal) {
        // Given(준비)
        NumberGenerator testNumberGenerator = new TestNumberGenerator(ranVal);
        Car car = new Car("car", testNumberGenerator);

        // When(실행)
        car.move();
        // Then(검증)
        assertEquals(1, car.getTotalDistance());
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
