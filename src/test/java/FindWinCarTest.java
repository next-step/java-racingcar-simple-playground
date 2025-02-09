import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindWinCarTest {
    Car[] cars;
    FindWinCar fwc;

    @BeforeEach
    public void set(){
        cars = new Car[5];
        for(int i=0; i<5; ++i){
            cars[i] = new Car("car"+i);
        }

        fwc = new FindWinCar(5, cars);
    }

    @Test
    public void allMoveTest(){
        fwc.allMove(5);
        int[] locate = fwc.getLocate();

        assertNotNull(locate);
        for (int i = 0; i < 5; ++i){
            assertTrue(locate[i]>=0);
        }
    }

    @Test
    public void findWinTest_1(){
        fwc.allMove(10);
        Car[] winCar = fwc.findWin();

        assertTrue(winCar.length > 0);
    }

    @Test
    public void findWinTest_2(){
        fwc.allMove(10);
        Car[] winCar = fwc.findWin();

        assertTrue(winCar.length > 0);
    }

    @Test
    public void errorTest(){
        assertThrows(IllegalArgumentException.class, () -> new FindWinCar(0, cars));
        assertThrows(NullPointerException.class, () -> new FindWinCar(3, null));
        assertThrows(IllegalArgumentException.class, () -> fwc.allMove(-1));
    }

}
