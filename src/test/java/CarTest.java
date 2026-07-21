import domain.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 랜덤값_0과_3일때_멈춤(int randomValue) {
        // Given(준비)
        Car car = new Car("car");
        // When(실행)
        car.move(randomValue);
        // Then(검증)
        assertEquals(0, car.getTotalDistance());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 랜덤값_4와_9일때_전진(int randomValue) {
        // Given(준비)
        Car car = new Car("car");

        // When(실행)
        car.move(randomValue);
        // Then(검증)
        assertEquals(1, car.getTotalDistance());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "12345"})
    void 이름이_5글자_이하인_경우(String name) {
        assertDoesNotThrow(() -> new Car(name));
    }
    @ParameterizedTest
    @ValueSource(strings = {"123456", "12345678", "1234567890"})
    void 이름이_5글자_초과인_경우(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new Car(name));

        assertEquals("자동차 이름은 5자 이하여야 합니다.", exception.getMessage());
    }
}
