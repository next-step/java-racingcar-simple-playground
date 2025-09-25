package io.suhan.racingcar.domain;

import static io.suhan.racingcar.domain.Car.CAR_MOVE_THRESHOLD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.suhan.racingcar.generator.FixedNumberGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class CarTest {
    @Test
    void 자동차는_이름을_가지고_있다() {
        String name = "neo";

        Car car = Car.of(name);

        assertEquals(name, car.getName());
    }

    @Test
    void 생성된_값이_4_이상일_경우_자동차가_움직일_수_있다() {
        FixedNumberGenerator generator = new FixedNumberGenerator(CAR_MOVE_THRESHOLD);
        Car car = Car.of("neo", generator);

        car.move();

        int position = car.getPosition();

        assertNotEquals(0, position);
    }

    @Test
    void 생성된_값이_3_이하일_경우_자동차가_멈춘다() {
        FixedNumberGenerator generator = new FixedNumberGenerator(CAR_MOVE_THRESHOLD - 1);
        Car car = Car.of("neo", generator);

        car.move();

        int position = car.getPosition();

        assertEquals(0, position);
    }

    @Test
    void 자동차의_이름은_5자_이하만_가능하다() {
        assertThrows(IllegalArgumentException.class, () -> Car.of("123456"));
    }
}
