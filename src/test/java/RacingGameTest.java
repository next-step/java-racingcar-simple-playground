import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RacingGameTest {
    private static final int MOVABLE_NUM = 4;

    @Test
    void findsSingleWinner() {
        // 준비
        Car first = new Car("Green");
        Car second = new Car("Blue");
        first.move(MOVABLE_NUM);
        first.move(MOVABLE_NUM);
        second.move(MOVABLE_NUM);
        // 실행
        RacingGame game = new RacingGame(Arrays.asList(first, second), new FixedNumberGenerator(4));
        // 검증
        assertThat(game.getWinners()).containsExactly("Green");
    }

    @Test
    void findsJointWinners() {
        // 준비
        Car first = new Car("Green");
        Car second = new Car("Blue");
        Car third = new Car("Red");
        first.move(MOVABLE_NUM);
        second.move(MOVABLE_NUM);
        // 실행
        RacingGame game = new RacingGame(Arrays.asList(first, second, third), new FixedNumberGenerator(4));
        // 검증
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder("Green", "Blue");
    }

    @Test
    void allCarsNonMove() {
        // 준비
        Car first = new Car("Green");
        Car second = new Car("Blue");
        // 실행
        RacingGame game = new RacingGame(Arrays.asList(first, second), new FixedNumberGenerator(4));
        // 검증
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder("Green", "Blue");
    }

    @Test
    void singleCarWin() {
        // 준비
        Car car = new Car("Green");
        // 실행
        RacingGame game = new RacingGame(List.of(car), new FixedNumberGenerator(4));
        // 검증
        assertThat(game.getWinners()).containsExactly("Green");
    }

    @Test
    void rejectsEmptyCars() {
        // 준비
        List<Car> cars = new ArrayList<>();
        // 실행 및 검증
        assertThatThrownBy(() -> new RacingGame(cars, new FixedNumberGenerator(4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void rejectsNegativeRounds() {
        // 준비
        List<Car> cars = Arrays.asList(new Car("Green"));
        RacingGame game = new RacingGame(cars, new FixedNumberGenerator(4));
        // 실행 및 검증
        assertThatThrownBy(() -> game.race(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void allCarsMoveAllRound() {
        // 준비
        Car first = new Car("Green");
        Car second = new Car("Blue");
        List<Car> cars = Arrays.asList(first, second);
        RacingGame game = new RacingGame(cars, new FixedNumberGenerator(4));
        // 실행
        game.race(3);
        // 검증
        assertThat(first.getPosition()).isEqualTo(3);
        assertThat(second.getPosition()).isEqualTo(3);
    }

    @Test
    void allCarsStayAllRound() {
        // 준비
        Car first = new Car("Green");
        Car second = new Car("Blue");
        List<Car> cars = Arrays.asList(first, second);
        RacingGame game = new RacingGame(cars, new FixedNumberGenerator(3));
        // 실행
        game.race(3);
        // 검증
        assertThat(first.getPosition()).isEqualTo(0);
        assertThat(second.getPosition()).isEqualTo(0);
    }

    @Test
    void keepsPositionWhenRoundsAreZero() {
        // 준비
        Car car = new Car("neo");
        car.move(4);
        RacingGame game = new RacingGame(List.of(car), new FixedNumberGenerator(4));
        // 실행
        game.race(0);
        // 검증
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void generatesNumberForEachCarInEveryRound() {
        // 준비
        Car first = new Car("neo");
        Car second = new Car("brie");
        Queue<Integer> numbers = new ArrayDeque<>(List.of(4, 3, 9, 0));
        RacingGame game = new RacingGame(List.of(first, second), () -> numbers.remove());
        // 실행
        game.race(2);
        // 검증
        assertThat(first.getPosition()).isEqualTo(2);
        assertThat(second.getPosition()).isZero();
        assertThat(numbers).isEmpty();
    }
}
