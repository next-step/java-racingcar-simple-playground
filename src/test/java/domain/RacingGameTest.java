package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
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
    @DisplayName("move all cars test -> all move")
    public void moveAllCarTest() {
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3"), 1, () -> true);

        racingGame.moveCars();
        for (RacingCar car : racingGame.getCars()) {
            assertThat(car.getDistance()).isEqualTo(1);
        }

    }

    @Test
    @DisplayName("move all cars test -> all stop")
    public void moveAllCarTest2() {
        RacingGame racingGame = new RacingGame(Arrays.asList("test1", "test2", "test3"), 1, () -> false);

        racingGame.moveCars();
        for (RacingCar car : racingGame.getCars()) {
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("tryCount exception test")
    public void validateTryCountTest() {
        assertThatThrownBy(() -> new RacingGame(Arrays.asList("test1"), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}
