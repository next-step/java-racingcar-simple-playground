import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RacingGameTest {
    private static final int MOVABLE_NUM = 4;

    @Test
    void findsSingleWinner() {

        //준비
        Car first = new Car("Green");
        Car second = new Car("Blue");
        first.move(MOVABLE_NUM);
        first.move(MOVABLE_NUM);
        second.move(MOVABLE_NUM);

        //실행
        RacingGame game = new RacingGame(Arrays.asList(first, second));

        //검즘
        assertThat(game.getWinners()).containsExactly("Green");
    }

    @Test
    void findsJointWinners() {
        //준비
        Car first = new Car("Green");
        Car second = new Car("Blue");
        Car third = new Car("Red");
        first.move(MOVABLE_NUM);
        second.move(MOVABLE_NUM);

        //실행
        RacingGame game = new RacingGame(Arrays.asList(first, second, third));

        //검즘
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder("Green", "Blue");
    }

    @Test
    void allCarsNonMove() {
        //준비
        Car first = new Car("Green");
        Car second = new Car("Blue");

        //실행
        RacingGame game = new RacingGame(Arrays.asList(first, second));

        //검즘
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder("Green", "Blue");
    }

    @Test
    void singleCarWin() {
        //준비
        Car car = new Car("Green");

        //실행
        RacingGame game = new RacingGame(List.of(car));

        //검즘
        assertThat(game.getWinners()).containsExactly("Green");
    }

    @Test
    void rejectsEmptyCars() {
        // 준비
        List<Car> cars = new ArrayList<>();

        // 실행, 검증
        assertThatThrownBy(() -> new RacingGame(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void rejectsNegativeRounds() {
        // 준비
        List<Car> cars = Arrays.asList(new Car("Green"));
        RacingGame game = new RacingGame(cars);

        // 실행, 검증
        assertThatThrownBy(() -> game.race(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
