import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    private List<Car> cars;

    @BeforeEach
    void init() {
        cars = new ArrayList<>();

        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        Car car3 = new Car("test3");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @Test
    void 전진_조건이면_주어진_횟수만큼_모든_자동차의_position이_증가한다() {
        RacingGame racingGame = new RacingGame(cars, () -> 4);

        racingGame.run(3);

        assertThat(cars).extracting(Car::getPosition).containsExactly(3, 3, 3);
    }

    @Test
    void position의_값이_가장_높은_자동차가_우승한다() {
        RacingGame racingGame = new RacingGame(cars, () -> 4);

        cars.get(0).move(4);
        cars.get(1).move(2);
        cars.get(2).move(1);

        assertThat(racingGame.findWinners()).containsExactly(cars.get(0));
    }

    @Test
    void position의_최댓값이_동일한_자동차가_있다면_우승자는_여러명이_존재할_수_있다() {
        RacingGame racingGame = new RacingGame(cars, () -> 4);

        cars.get(0).move(4);
        cars.get(1).move(2);
        cars.get(2).move(6);

        assertThat(racingGame.findWinners()).containsExactlyInAnyOrder(cars.get(0), cars.get(2));
    }

    @Test
    void 참여한_자동차가_없다면_예외를_던진다() {
        List<Car> empty = new ArrayList<>();
        RacingGame racingGame = new RacingGame(empty, () -> 4);

        assertThatThrownBy(racingGame::findWinners)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
