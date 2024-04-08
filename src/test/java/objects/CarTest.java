package objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("테스트 이름")
    void cartest() {
        Car car = new Car("ads");
        car.setName("newName");

       assertEquals("newName", car.getName());
    }

    @Test
    @DisplayName("테스트 이름")
    void cartest2() {
        Car car = new Car("ads");
        car.setName("newName");

        assertEquals("newName", car.getName());
    }


}