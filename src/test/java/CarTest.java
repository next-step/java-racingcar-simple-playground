import domain.Car;
import domain.NumberGenerator;
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

    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "12345"})
    void 이름이_5글자_이하인_경우(String name) {
        //Given
        NumberGenerator testNumberGenerator = new TestNumberGenerator(0);

        //When & Then
        assertDoesNotThrow(() -> new Car(name, testNumberGenerator));
    }
    @ParameterizedTest
    @ValueSource(strings = {"123456", "12345678", "1234567890"})
    void 이름이_5글자_초과인_경우(String name) {
        //Given
        NumberGenerator testNumberGenerator = new TestNumberGenerator(0);

        //When & Then
        assertThrows(IllegalArgumentException.class, ()
                -> new Car(name, testNumberGenerator));
    }
}
