package model;

import common.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private static final int MOVE_NUMBER = 4;
    private static final int STOP_NUMBER = 3;
    private final List<Integer> numbers_winners_one = List.of(
            MOVE_NUMBER, MOVE_NUMBER, STOP_NUMBER,
            STOP_NUMBER, MOVE_NUMBER, STOP_NUMBER,
            STOP_NUMBER, MOVE_NUMBER, STOP_NUMBER
    );
    private final List<Integer> numbers_winners_two = List.of(
            MOVE_NUMBER, MOVE_NUMBER, STOP_NUMBER,
            MOVE_NUMBER, MOVE_NUMBER, STOP_NUMBER,
            MOVE_NUMBER, MOVE_NUMBER, STOP_NUMBER
    );

    @Test
    @DisplayName("OK : 한 대가 우승함")
    void playRacing_one_winners() {
        Racing racing = new Racing(new FakeRandom(numbers_winners_one), 3, 3);
        List<Car> result = racing.play();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("OK : 다수가 우승함")
    void playRacing_two_winners() {
        Racing racing = new Racing(new FakeRandom(numbers_winners_two), 3, 3);
        List<Car> result = racing.play();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.stream().map(Car::getName).toList()).contains("test1", "test2");
    }
}
