import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void findsSingleWinner() {

        //준비
        Car first = new Car("Greedy");
        Car second = new Car("GReedy");
        first.move(4);
        first.move(4);
        second.move(4);

        //실행
        RacingGame game = new RacingGame(Arrays.asList(first, second));

        //검즘
        assertThat(game.getWinners()).containsExactly("Greedy");
    }

    @Test
    void findsJointWinners() {
        //준비
        Car first = new Car("Greedy");
        Car second = new Car("GReedy");
        Car third = new Car("GREedy");
        first.move(4);
        second.move(4);

        //실행
        RacingGame game = new RacingGame(Arrays.asList(first, second, third));

        //검즘
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder("Greedy", "GReedy");
    }

    @Test
    void allCarsNonMove() {
        //준비
        Car first = new Car("Greedy");
        Car second = new Car("GReedy");

        //실행
        RacingGame game = new RacingGame(Arrays.asList(first, second));

        //검즘
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder("Greedy", "GReedy");
    }

    @Test
    void singleCarWin() {
        //준비
        Car car = new Car("Greedy");

        //실행
        RacingGame game = new RacingGame(Arrays.asList(car));

        //검즘
        assertThat(game.getWinners()).containsExactly("Greedy");
    }
}