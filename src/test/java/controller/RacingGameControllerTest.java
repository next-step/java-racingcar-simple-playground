package controller;

import dto.CarProgressDto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import view.TestInputView;
import view.TestOutputView;

import java.util.List;
import java.util.stream.Stream;

class RacingGameControllerTest {

    @ParameterizedTest(name = "[{index}] 자동차: {0}, 라운드: {1}")
    @MethodSource("testCases")
    @DisplayName("자동차 이름과 라운드 수에 따라 게임을 실행하고 우승자를 검증한다")
    void runGameAndVerifyResult(String inputNames, String roundCount, List<Integer> expectedPositions, List<String> expectedWinners) {
        // given
        TestInputView inputView = new TestInputView(List.of(inputNames, roundCount));
        TestOutputView outputView = new TestOutputView();
        RacingGameController controller = new RacingGameController(inputView, outputView, () -> 9);

        // when
        controller.run();

        // then
        SoftAssertions softly = new SoftAssertions();

        // 1. 라운드 수 검증
        softly.assertThat(outputView.roundResults)
                .as("라운드 수 검증")
                .hasSize(Integer.parseInt(roundCount));

        // 2. 마지막 라운드의 위치 값 검증
        List<CarProgressDto> lastRound = outputView.roundResults.get(outputView.roundResults.size() - 1);
        List<Integer> actualPositions = lastRound.stream()
                .map(CarProgressDto::position)
                .toList();

        softly.assertThat(actualPositions)
                .as("최종 라운드 위치 검증")
                .containsExactlyElementsOf(expectedPositions);

        // 3. 우승자 검증
        List<String> actualWinners = outputView.winners.names();

        softly.assertThat(actualWinners)
                .as("우승자 검증")
                .containsExactlyInAnyOrderElementsOf(expectedWinners);

        softly.assertAll();
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("neo,brie", "1", List.of(1, 1), List.of("neo", "brie")),
                Arguments.of("neo,brie,brown", "2", List.of(2, 2, 2), List.of("neo", "brie", "brown")),
                Arguments.of("a,b", "3", List.of(3, 3), List.of("a", "b"))
        );
    }
}
