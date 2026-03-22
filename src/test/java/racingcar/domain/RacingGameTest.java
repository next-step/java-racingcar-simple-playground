package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.NumberGenerator;
import racingcar.generator.TestNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("한 번의 라운드에서 자동차들이 전진 또는 멈춘다")
    void playRound() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        NumberGenerator generator = new TestNumberGenerator(List.of(4, 3));
        Cars cars = new Cars(List.of(pobi, crong));
        RacingGame racingGame = new RacingGame(cars, generator);

        racingGame.playRound();

        assertThat(pobi.getPosition()).isEqualTo(1);
        assertThat(crong.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("한 명이 우승한다")
    void oneWinner() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        NumberGenerator generator = new TestNumberGenerator(List.of(4, 3, 4, 4));
        Cars cars = new Cars(List.of(pobi, crong));
        RacingGame racingGame = new RacingGame(cars, generator);

        racingGame.playRound();
        racingGame.playRound();

        assertThat(racingGame.getWinners())
                .extracting(Car::getName)
                .containsExactly("pobi");
    }

    @Test
    @DisplayName("다수가 우승한다")
    void multipleWinners() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        NumberGenerator generator = new TestNumberGenerator(List.of(4, 4, 3, 3));
        Cars cars = new Cars(List.of(pobi, crong));
        RacingGame racingGame = new RacingGame(cars, generator);

        racingGame.playRound();
        racingGame.playRound();

        assertThat(racingGame.getWinners())
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "crong");
    }

    @Test
    @DisplayName("아무도 움직이지 않으면 우승자는 없다")
    void noWinners() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        NumberGenerator generator = new TestNumberGenerator(List.of(3, 3, 3, 3));
        Cars cars = new Cars(List.of(pobi, crong));
        RacingGame racingGame = new RacingGame(cars, generator);

        racingGame.playRound();
        racingGame.playRound();

        assertThat(racingGame.getWinners()).isEmpty();
    }
}
