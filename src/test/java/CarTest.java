import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void testCarName(){
        Car car = new Car("KIA");
        assertEquals("KIA", car.getName());
    }

    @Test
    void testCarMove(){
        Car car = new Car("TestCar");
        car.move(4);
        assertEquals(1, car.getDistance());
    }

    @Test
    void testCarNotMove(){
        Car car = new Car("TestCar");
        car.move(3);
        assertEquals(0, car.getDistance());
    }
}
