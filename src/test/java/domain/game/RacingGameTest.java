package domain.game;

import domain.generator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Test
    @DisplayName("자동차 여러대 생성 테스트")
    void create_cars_from_comma_separated_names() {
        RacingGame racingGame = new RacingGame("white, blue, red");

        assertThat(racingGame.getCars())
                .extracting("name", "location")
                .containsExactly(
                        org.assertj.core.groups.Tuple.tuple("white", 0),
                        org.assertj.core.groups.Tuple.tuple("blue", 0),
                        org.assertj.core.groups.Tuple.tuple("red", 0)
                );
    }

    @Test
    @DisplayName("자동차 여러대일 때 ',' trim 테스트")
    void trim_car_names_when_creating_cars() {
        RacingGame racingGame = new RacingGame("white, blue");

        assertThat(racingGame.getCars())
                .extracting("name")
                .containsExactly("white", "blue");
    }

    @Test
    @DisplayName("자동차 목록 불변 반환 테스트")
    void return_unmodifiable_cars() {
        RacingGame racingGame = new RacingGame("white, blue");

        assertThatThrownBy(() -> racingGame.getCars().add(null))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("차 레이싱 기능 테스트")
    void race_each_car_with_generated_numbers() {
        RacingGame racingGame = new RacingGame("white,blue,red");

        racingGame.race(new SequenceNumberGenerator(4, 3, 9));

        assertThat(racingGame.getCars())
                .extracting("location")
                .containsExactly(1, 0, 1);
    }

    @Test
    @DisplayName("레이싱 여러 번 반복시 캐싱 버그 테스트")
    void accumulate_location_when_racing_multiple_times() {
        RacingGame racingGame = new RacingGame("white, blue");

        racingGame.race(new FixedNumberGenerator(4));
        racingGame.race(new FixedNumberGenerator(4));

        assertThat(racingGame.getCars())
                .extracting("location")
                .containsExactly(2, 2);
    }

    @Test
    @DisplayName("우승자 찾기 검증 테스트")
    void find_winners_after_race() {
        RacingGame racingGame = new RacingGame("white,blue,red");

        racingGame.race(new SequenceNumberGenerator(4, 3, 9));

        assertThat(racingGame.findWinners()).containsExactly("white", "red");
    }

    private static class FixedNumberGenerator implements NumberGenerator {
        private final int number;

        private FixedNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int getNumber() {
            return number;
        }
    }

    private static class SequenceNumberGenerator implements NumberGenerator {
        private final int[] numbers;
        private int index;

        private SequenceNumberGenerator(int... numbers) {
            this.numbers = numbers;
        }

        @Override
        public int getNumber() {
            return numbers[index++];
        }
    }
}
