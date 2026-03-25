
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {
    @Test
    @DisplayName("Car 객체, 이름 반환 test")
    public void Test_getName() {
        Car car = new Car("A");
        Assertions.assertEquals("A", car.getName());
    }

    @Test
    @DisplayName("정지 test[0-3]")
    public void Test_underForwardThreshold() {
        Car car = new Car("A");
        car.move(3);
        Assertions.assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("전진 test[4-9]")
    public void Test_overForwardThreshold() {
        Car car = new Car("A");
        car.move(4);
        Assertions.assertEquals(1, car.getPosition());
    }
}
