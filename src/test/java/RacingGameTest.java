import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("한명이 우승했다")
    void oneWinner() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        pobi.move(4);
        pobi.move(4);
        crong.move(4);

        RacingGame racingGame = new RacingGame(List.of(pobi, crong));

        List<Car> winners = racingGame.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("다수가 우승했다")
    void winners() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        pobi.move(4);
        crong.move(4);

        RacingGame racingGame = new RacingGame(List.of(pobi, crong));

        List<Car> winners = racingGame.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
        assertThat(winners.get(1).getName()).isEqualTo("crong");
    }

}