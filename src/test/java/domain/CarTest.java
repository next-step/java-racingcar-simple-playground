package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import generator.FixedNumGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 랜덤값이_3이면_멈춤() {
        Car car = new Car("Car1", 0);
        FixedNumGenerator fixedNumber = new FixedNumGenerator(List.of(3));

        car.moveCar(fixedNumber);

        assertTrue(car.isSamePosition(0));
    }

    @Test
    void 랜덤값이_4이면_한칸_이동() {
        Car car = new Car("Car1", 0);
        FixedNumGenerator fixedNumber = new FixedNumGenerator(List.of(4));

        car.moveCar(fixedNumber);

        assertTrue(car.isSamePosition(1));
    }

    @Test
    void 현재_위치보다_큰_위치가_오면_큰_위치_반환() {
        Car car = new Car("Car1", 0);
        assertEquals(1, car.getLargerPosition(1));
    }

    @Test
    void 자동차의_위치들이_같은지_확인() {
        Car car = new Car("Car1", 1);

        assertTrue(car.isSamePosition(1));
    }

    @Test
    void 자동차_이름_조회() {
        Car car = new Car("Car1", 0);
        assertEquals("Car1", car.getName());
    }

    @Test
    void 자동차_위치_조회() {
        Car car = new Car("Car1", 2);
        assertEquals(2, car.getPosition());
    }
}
