import domain.RacingCar;
import domain.RacingGame;
import view.InputView;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RefactorTest {

    @Test
    @DisplayName("racing car move test success")
    public void moveTest() {
        RacingCar car = new RacingCar("test");
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("racing car move test fail")
    public void moveTest2() {
        RacingCar car = new RacingCar("test");
        car.move(1);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("one winner")
    public void winnerTest() {
        RacingCar car1 = new RacingCar("test1");
        RacingCar car2 = new RacingCar("test2");
        RacingCar car3 = new RacingCar("test3");
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3"), 1);

        List<RacingCar> cars = Arrays.asList(car1, car2, car3);
        List<RacingCar> winners = new ArrayList<>();

        car1.move(5);
        car2.move(1);
        car3.move(1);

        winners = racingGame.whoWin(cars);
        final var expected = List.of(car1);

        assertThat(winners).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("one more winner")
    public void winnerTest2() {
        RacingCar car1 = new RacingCar("test1");
        RacingCar car2 = new RacingCar("test2");
        RacingCar car3 = new RacingCar("test3");
        RacingCar car4 = new RacingCar("test4");
        RacingCar car5 = new RacingCar("test5");
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3", "test4", "test5"), 1);

        List<RacingCar> cars = Arrays.asList(car1, car2, car3, car4, car5);
        List<RacingCar> winners = new ArrayList<>();

        car1.move(5);
        car2.move(1);
        car3.move(5);
        car4.move(5);
        car5.move(1);

        winners = racingGame.whoWin(cars);
        final var expected = List.of(car1, car3, car4);

        assertThat(winners).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("All winner, All move fail")
    public void winnerTest3() {
        RacingCar car1 = new RacingCar("test1");
        RacingCar car2 = new RacingCar("test2");
        RacingCar car3 = new RacingCar("test3");
        RacingCar car4 = new RacingCar("test4");
        RacingCar car5 = new RacingCar("test5");
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3", "test4", "test5"), 1);

        List<RacingCar> cars = Arrays.asList(car1, car2, car3, car4, car5);
        List<RacingCar> winners = new ArrayList<>();

        car1.move(1);
        car2.move(2);
        car3.move(3);
        car4.move(4);
        car5.move(1);

        winners = racingGame.whoWin(cars);
        final var expected = List.of(car1, car2, car3, car4, car5);

        assertThat(winners).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("exception test")
    public void nameLengthExceptionTest() {
        assertThatThrownBy(() -> new RacingCar("toolongname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다");
    }

    @Test
    @DisplayName("move all cars test -> all move")
    public void moveAllCarTest() {
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3"), 1, ()->4);

        racingGame.moveCars();
        for(RacingCar car : racingGame.getCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }

    }

    @Test
    @DisplayName("move all cars test -> all stop")
    public void moveAllCarTest2() {
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3"), 1, ()->1);

        racingGame.moveCars();
        for(RacingCar car : racingGame.getCars()) {
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

}
