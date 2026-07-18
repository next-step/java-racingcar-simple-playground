//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.Random;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class RacingCarTest {
//
//    @Test
//    @DisplayName("racing car move test")
//    public void moveTest() {
//        RacingCar car = new RacingCar("test");
//        int num = car.randomNum();
//        int dis = 0;
//
//        car.move(num);
//
//        if(dis < car.getDistance()) {
//            assertThat(num).isGreaterThanOrEqualTo(4);
//        }
//        else {
//            assertThat(num).isLessThan(4);
//        }
//        dis = car.getDistance();
//    }
//}
