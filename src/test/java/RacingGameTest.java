import domain.Car;
import domain.FixedNumberGenerator;
import domain.NumberMovingStrategy;
import domain.RacingGame;
import domain.SequenceNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Nested
    @DisplayName("게임 생성 테스트")
    class create {

        @Test
        @DisplayName("입력한 이름 수만큼 자동차가 생성되는지 테스트")
        void 이름_수만큼_자동차_생성() {
            List<String> carNames = List.of(
                    "AAA", "BBB", "CCC"
            );
            int expectedCarCount = 3;

            RacingGame game = new RacingGame(carNames, 1, new FixedNumberGenerator(0), new NumberMovingStrategy());

            assertThat(game.getCars()).hasSize(expectedCarCount);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1})
        @DisplayName("시도 횟수가 0 이하면 예외 발생 테스트")
        void 시도_횟수가_0_이하면_예외_발생(int tryCount) {
            List<String> carNames = List.of(
                    "AAA", "BBB", "CCC"
            );
            String throwMessage = "시도 횟수는 1 이상이어야 합니다.";

            assertThatThrownBy(() ->
                    new RacingGame(carNames, tryCount, new FixedNumberGenerator(0), new NumberMovingStrategy()))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(throwMessage);
        }
    }

    @Nested
    @DisplayName("라운드 진행 테스트")
    class round {

        @Test
        @DisplayName("모든 차가 1칸씩 전진하는지 테스트")
        void 모든_자동차가_한칸_전진() {
            List<String> carNames = List.of(
                    "AAA", "BBB", "CCC"
            );
            int expectedPosition = 1;

            RacingGame game = new RacingGame(carNames, 1, new FixedNumberGenerator(9), new NumberMovingStrategy());
            game.playRound();

            assertThat(game.getCars())
                    .extracting(Car::getPosition)
                    .containsOnly(expectedPosition);
        }
    }

    @Nested
    @DisplayName("우승자 판별 테스트")
    class winner {

        @Test
        @DisplayName("단독 우승 테스트")
        void 단독_우승() {
            List<String> carNames = List.of(
                    "AAA", "BBB", "CCC"
            );
            SequenceNumberGenerator generator = new SequenceNumberGenerator(1, 6, 3); // BBB만 전진

            RacingGame game = new RacingGame(carNames, 1, generator, new NumberMovingStrategy());
            game.playRound();

            assertThat(game.getWinners())
                    .extracting(Car::getName)
                    .containsExactly("BBB");
        }

        @Test
        @DisplayName("공동 우승 테스트")
        void 공동_우승() {
            List<String> carNames = List.of(
                    "AAA", "BBB", "CCC"
            );
            SequenceNumberGenerator generator = new SequenceNumberGenerator(3, 4, 4); // BBB, CCC 전진

            RacingGame game = new RacingGame(carNames, 1, generator, new NumberMovingStrategy());
            game.playRound();

            assertThat(game.getWinners())
                    .extracting(Car::getName)
                    .containsExactly("BBB", "CCC");
        }
    }
}
