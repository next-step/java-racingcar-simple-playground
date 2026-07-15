//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class WinRacingCarTest {
//
//    @Test
//    @DisplayName("one winner")
//    public void winnerTest() {
//        RacingCar car1 = new RacingCar("test1");
//        RacingCar car2 = new RacingCar("test2");
//        RacingCar car3 = new RacingCar("test3");
//        WinRacingCar win = new WinRacingCar();
//
//        List<RacingCar> cars = Arrays.asList(car1, car2, car3);
//        List<RacingCar> winners = new ArrayList<>();
//
//        car1.move(5);
//        car2.move(1);
//        car3.move(1);
//
//        winners = win.whoWin(cars);
//        final var expected = List.of(car1);
//
//        assertThat(winners).containsExactlyElementsOf(expected);
//    }
//
//    @Test
//    @DisplayName("one more winner")
//    public void winnerTest2() {
//        RacingCar car1 = new RacingCar("test1");
//        RacingCar car2 = new RacingCar("test2");
//        RacingCar car3 = new RacingCar("test3");
//        RacingCar car4 = new RacingCar("test4");
//        RacingCar car5 = new RacingCar("test5");
//        WinRacingCar winRacingCar = new WinRacingCar();
//
//        List<RacingCar> cars = Arrays.asList(car1, car2, car3, car4, car5);
//        List<RacingCar> winners = new ArrayList<>();
//
//        car1.move(5);
//        car2.move(1);
//        car3.move(5);
//        car4.move(5);
//        car5.move(1);
//
//        winners = winRacingCar.whoWin(cars);
//        final var expected = List.of(car1, car3, car4);
//
//        assertThat(winners).containsExactlyElementsOf(expected);
//    }
//}
