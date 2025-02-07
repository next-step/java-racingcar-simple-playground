import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;



public class RacingCarTest {
    private RacingCar3 car1;
    private RacingCar3 car2;

    @BeforeEach
    void setUp(){
        car1 = new RacingCar3("Car1");
        car2 = new RacingCar3("Car2");
    }
    @Test
    void move_RandomValueGreaterThanFour(){
      int initialSpace = car1.getSpace();
      for (int i=0; i<20; i++){
          car1.move();
      }
      assertThat(car1.getSpace()).isGreaterThanOrEqualTo(initialSpace);
    }

    @Test
    void move_RandomValueLessThanFour(){
        int initialSpace = car1.getSpace();
        for (int i=0; i<20; i++){
            car1.move();
        }
        assertThat(car1.getSpace()).isGreaterThanOrEqualTo(initialSpace);
    }
    @Test
    void WinTestCar1() {
        car1.move();
        car1.move();
        car1.move();
        car2.move();

        assertThat(car1.Win(car2)).isEqualTo(1);
    }
}

