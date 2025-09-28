package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    void 이름리스트로Cars를생성한다() {
        // given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        // when
        Cars cars = Cars.createCars(carNames);

        // then
        assertEquals(3, cars.getCars().size());
        assertEquals("car1", cars.getCars().get(0).getCarName());
        assertEquals("car2", cars.getCars().get(1).getCarName());
        assertEquals("car3", cars.getCars().get(2).getCarName());
    }

    @Test
    void 자동차를추가할수있다() {
        // given
        Cars cars = Cars.createCars(Arrays.asList("car1"));
        Car car2 = Car.createCarByCarName(new CarName("car2"));

        // when
        cars.addCar(car2);

        // then
        assertEquals(2, cars.getCars().size());
        assertEquals("car2", cars.getCars().get(1).getCarName());
    }
}
