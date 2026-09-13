import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
