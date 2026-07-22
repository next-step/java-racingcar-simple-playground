package domain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("숫자가 4이상이면 자동차가 전진한다")
    void movesWhenNumberIsGreaterThanThree() {
        Car car = new Car("test");

        car.move(4);

        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("숫자가 3이하이면 자동차가 멈춘다")
    void doesNotMoveWhenNumberIsThreeOrLess() {
        Car car = new Car("test");

        car.move(3);

        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void throwExceptionWhenNameExceedsFiveCharacters() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Car("abcdef")
        );        
    }
}
