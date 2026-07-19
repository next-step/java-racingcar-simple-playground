import domain.RacingCar;
import domain.RacingGame;
import view.InputView;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RefactorTest {

    @Test
    @DisplayName("racing car move test success")
    public void moveTest() {
        RacingCar car = new RacingCar("test");
        car.move(true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("racing car move test fail")
    public void moveTest2() {
        RacingCar car = new RacingCar("test");
        car.move(false);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("one winner")
    public void winnerTest() {
        List<Boolean> results = Arrays.asList(true, false, false);
        Iterator<Boolean> iterator = results.iterator();
        RacingGame racingGame = new RacingGame(
                Arrays.asList("test1", "test2", "test3"),
                1,
                iterator::next);

        racingGame.moveCars();

        List<RacingCar> winners = racingGame.whoWin();

        assertThat(winners).extracting(car -> car.getName())
                .containsExactly("test1");
    }

    @Test
    @DisplayName("one more winner")
    public void winnerTest2() {
        List<Boolean> results = Arrays.asList(true, false, true, true, false);
        Iterator<Boolean> iterator = results.iterator();
        RacingGame racingGame = new RacingGame(
                Arrays.asList("test1", "test2", "test3", "test4", "test5"),
                1,
                iterator::next);

        racingGame.moveCars();

        List<RacingCar> winners = racingGame.whoWin();

        assertThat(winners).extracting(car -> car.getName())
                .containsExactly("test1", "test3", "test4");
    }

    @Test
    @DisplayName("All winner, All move fail")
    public void winnerTest3() {
        List<Boolean> results = Arrays.asList(false, false, false, false, false);
        Iterator<Boolean> iterator = results.iterator();
        RacingGame racingGame = new RacingGame(
                Arrays.asList("test1", "test2", "test3", "test4", "test5"),
                1,
                iterator::next);

        racingGame.moveCars();

        List<RacingCar> winners = racingGame.whoWin();

        assertThat(winners).extracting(car -> car.getName())
                .containsExactly("test1", "test2", "test3", "test4", "test5");
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
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3"), 1, () -> true);

        racingGame.moveCars();
        for(RacingCar car : racingGame.getCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }

    }

    @Test
    @DisplayName("move all cars test -> all stop")
    public void moveAllCarTest2() {
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3"), 1, () -> false);

        racingGame.moveCars();
        for(RacingCar car : racingGame.getCars()) {
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }
}
