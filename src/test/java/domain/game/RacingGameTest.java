package domain.game;

import domain.generator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름을 입력하면 자동차 목록을 생성한다")
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
    @DisplayName("자동차 이름 앞뒤에 공백이 있으면 공백을 제거하고 자동차를 생성한다")
    void trim_car_names_when_creating_cars() {
        RacingGame racingGame = new RacingGame("white, blue");

        assertThat(racingGame.getCars())
                .extracting("name")
                .containsExactly("white", "blue");
    }

    @Test
    @DisplayName("자동차 목록을 조회한 뒤 외부에서 수정하려 하면 예외가 발생한다")
    void return_unmodifiable_cars() {
        RacingGame racingGame = new RacingGame("white, blue");

        assertThatThrownBy(() -> racingGame.getCars().add(null))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("자동차별 생성 숫자가 이동 조건을 만족하면 해당 자동차만 전진한다")
    void race_each_car_with_generated_numbers() {
        RacingGame racingGame = new RacingGame("white,blue,red");

        racingGame.race(new SequenceNumberGenerator(4, 3, 9));

        assertThat(racingGame.getCars())
                .extracting("location")
                .containsExactly(1, 0, 1);
    }

    @Test
    @DisplayName("같은 레이싱 게임에서 레이스를 여러 번 진행하면 위치가 누적된다")
    void accumulate_location_when_racing_multiple_times() {
        RacingGame racingGame = new RacingGame("white, blue");

        racingGame.race(new FixedNumberGenerator(4));
        racingGame.race(new FixedNumberGenerator(4));

        assertThat(racingGame.getCars())
                .extracting("location")
                .containsExactly(2, 2);
    }

    @Test
    @DisplayName("레이스가 끝난 뒤 가장 멀리 이동한 자동차 이름을 우승자로 반환한다")
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
