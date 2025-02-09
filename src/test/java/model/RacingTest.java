package model;

import common.FakeRandom;
import model.dto.RacingPlayResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fixture.FakeNumber.winnerNumbers;
import static fixture.FakeNumber.winnersNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    @DisplayName("OK : 한 대가 우승함")
    void playRacing_one_winners() {
        Racing racing = new Racing(new FakeRandom(winnerNumbers));
        RacingPlayResponse response = racing.play("neo,brie,brown", 5);
        assertThat(response.winners().size()).isEqualTo(1);
        assertThat(response.winners().stream().map(Car::getName).toList()).contains("brie");
    }

    @Test
    @DisplayName("OK : 다수가 우승함")
    void playRacing_two_winners() {
        Racing racing = new Racing(new FakeRandom(winnersNumbers));
        RacingPlayResponse response = racing.play("neo,brie,brown", 5);
        assertThat(response.winners().size()).isEqualTo(2);
        assertThat(response.winners().stream().map(Car::getName).toList()).contains("neo", "brown");
    }

    @Test
    @DisplayName("OK : raceCount가 0이면 모두 공동 우승")
    void playRacing_zero_raceCount() {
        Racing racing = new Racing(new FakeRandom(winnerNumbers));
        RacingPlayResponse response = racing.play("neo,brie,brown", 0);
        assertThat(response.winners().size()).isEqualTo(3);
        assertThat(response.winners().stream().map(Car::getName).toList()).contains("neo","brie","brown");
    }
}
