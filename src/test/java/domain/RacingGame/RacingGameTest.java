package domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingGameTest {

    static RacingGame racingGame;

    static TestNumberGenerator numberGenerator;
    static String car1 = "참가자1";
    static String car2 = "참가자2";
    static String car3 = "참가자3";

    static class TestNumberGenerator implements NumberGenerator {

        private List<Integer> numbers;
        private int index;

        TestNumberGenerator() {
            this.numbers = new ArrayList<>();
            this.index = 0;
        }

        public void setNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public void initIndex() {
            this.index = 0;
        }

        @Override
        public int generate() {
            return numbers.get(index++);
        }

    }

    @BeforeEach
    void initRacingGame() {
        numberGenerator = new TestNumberGenerator();
        List<String> participantNames = List.of(car1, car2, car3);
        racingGame = new RacingGame(numberGenerator, participantNames);
    }

    // getWinner()
    @Nested
    @DisplayName("우승자를 구하는 로직 테스트")
    class getWinner {

        private static Stream<Arguments> methodSourceOfGetWinnerTest() {
            return Stream.of(
                Arguments.arguments(List.of(1, 4, 1), Arrays.asList(car2)),
                Arguments.arguments(List.of(4, 4, 4), Arrays.asList(car1, car2, car3)),
                Arguments.arguments(List.of(1, 2, 3), Arrays.asList(car1, car2, car3)),
                Arguments.arguments(List.of(8, 9, 1), Arrays.asList(car1, car2))
            );
        }

        @ParameterizedTest(name = "각각 숫자 {0}이 주어진다면 우승자는 {1}이다.")
        @MethodSource("methodSourceOfGetWinnerTest")
        @DisplayName("참가자1, 참가자2, 참가자3에게 각각 숫자가 주어지고 이를 기반으로 움직였을 때, 우승자 구하기")
        void 우승자_구하기(List<Integer> inputNumbers, List<String> winnerNames) {
            // given
            numberGenerator.setNumbers(inputNumbers);
            // when
            racingGame.race();
            // then
            List<String> winners = racingGame.getWinner();
            assertThat(winners)
                .containsExactlyInAnyOrderElementsOf(winnerNames);
        }
    }

    @Nested
    @DisplayName("이동 후 현재 위치를 보여주는 메소드 테스트")
    class displayStatus {

        private static Stream<Arguments> methodSourceOfGetLocationByName() {
            return Stream.of(
                Arguments.arguments(List.of(1, 4, 1), List.of(4, 4, 4), List.of(1, 1, 1),
                                    Map.of(car1, 1, car2, 2, car3, 1)),
                Arguments.arguments(List.of(4, 4, 4), List.of(5, 6, 7), List.of(7, 8, 9),
                                    Map.of(car1, 3, car2, 3, car3, 3)),
                Arguments.arguments(List.of(1, 2, 3), List.of(3, 3, 5), List.of(1, 5, 5),
                                    Map.of(car1, 0, car2, 1, car3, 2))
            );
        }

        @ParameterizedTest(name = "각각 숫자 {0}, {1}, {2}가 주어진다면, 각 자동차별 location은 {3}이다.")
        @MethodSource("methodSourceOfGetLocationByName")
        @DisplayName("참가자1, 참가자2, 참가자3에게 각각 숫자가 주어지고 이를 기반으로 움직였을 때, 현재 ㅣocation 구하기")
        void 우승자_구하기(List<Integer> inputNumbers1, List<Integer> inputNumbers2, List<Integer> inputNumbers3,
                     Map<String, Integer> expectedLocationByName) {
            List<List<Integer>> inputNumbers = List.of(inputNumbers1, inputNumbers2, inputNumbers3);
            for (List<Integer> inputNumber : inputNumbers) {
                // given
                numberGenerator.setNumbers(inputNumber);
                // when
                racingGame.race();
                numberGenerator.initIndex();
            }
            // then
            Map<String, Integer> locationByName = racingGame.getLocationByName();
            System.out.println(locationByName);
            assertThat(locationByName)
                .containsExactlyInAnyOrderEntriesOf(expectedLocationByName);
        }
    }
}
