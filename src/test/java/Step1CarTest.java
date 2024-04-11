import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Step1CarTest {
    private Car car = new Car("test");
    Random random = new Random();

    @Test
    @DisplayName("이름 테스트")
    void checkNickName() {
        assertEquals("test", car.name);
    }

    @Test
    @DisplayName("전진 테스트")
    void moveFront() {
        assertEquals(1, car.move(4));
    }

    @Test
    @DisplayName("정지 해있는지 테스트")
    void moveStop() {
        assertEquals(0, car.move(2));
    }
}
