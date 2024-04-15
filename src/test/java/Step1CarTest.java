import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Car;

public class Step1CarTest {
    private Car car = new Car("test");
    Random random = new Random();

    @Test
    @DisplayName("이름 테스트")
    void checkNickName() {
        assertEquals("test", car.getName());
    }

    @Test
    @DisplayName("전진 테스트")
    void moveFront() {
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("정지 해있는지 테스트")
    void moveStop() {
        car.move(2);
        assertEquals(0, car.getPosition());
    }
}
