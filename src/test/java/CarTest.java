import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void createTest(){
        Car c = new Car("mercedes");
        assertEquals("mercedes", c.getName());
    }

    @Test
    public void errorTest(){
        assertThrows(NullPointerException.class, ()->new Car(null));
        assertThrows(IllegalArgumentException.class, ()->new Car(""));
    }

    @Test
    public void moveTest(){
        Car c = new Car("a");

        int tmp;
        for (int i = 0; i < 100; i++) {
            tmp = c.move();
            assertTrue(tmp == 1 || tmp == 0);
        }
    }

}
