package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.Errors;

class InputViewTest {

    InputView inputView = new InputView();

    private void setSetIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Nested
    @DisplayName("참가하는 자동차 이름을 받는 메소드 테스트")
    class TestOfGetParticipantNames {

        private static Stream<Arguments> methodSourceOfGetParticipantNames() {
            return Stream.of(
                Arguments.arguments("teo,neo,minju", List.of("teo", "neo", "minju")),
                Arguments.arguments( "app", List.of("app")),
                Arguments.arguments("hi,bi", List.of("hi", "bi"))
            );
        }

        @ParameterizedTest(name = "사용자가 {0}을 입력한다면 추출되는 참가자 이름 리스트는 {1}이다.")
        @MethodSource("methodSourceOfGetParticipantNames")
        @DisplayName("사용자 입력에서 쉼표를 기준으로 이름을 분리할 수 있다")
        void 사용자_이름_입력(String input, List<String> expectedNames) {
            // given
            setSetIn(input);
            // when
            List<String> participantNames = inputView.getParticipantNames();
            // then
            assertThat(participantNames)
                .containsExactlyInAnyOrderElementsOf(expectedNames);
        }

        private static Stream<Arguments> methodSourceOfValidateParticipantNames() {
            return Stream.of(
                Arguments.arguments("teo,neooooo", "neooooo"),
                Arguments.arguments("ttteoo,neo", "ttteoo"),
                Arguments.arguments("minjuuuu", "minjuuuu")
            );
        }

        @ParameterizedTest(name = "사용자가 {0}을 입력한다면 {1}의 길이가 5자리가 넘어 예외가 발생한다.")
        @MethodSource("methodSourceOfValidateParticipantNames")
        @DisplayName("입력된 이름이 다섯 글자가 넘어가면 예외가 발생한다.")
        void 이름_입력_검증(String userInput, String exceptionName) {
            // given
            setSetIn(userInput);
            // when
            // then
            assertThatThrownBy(() -> inputView.getParticipantNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Errors.getLengthOfCarNameError(exceptionName));
        }
    }

    @Nested
    @DisplayName("시도 횟수 받는 메소드 테스트")
    class TestOfGetTryCount {

        @ParameterizedTest(name = "사용자가 {0}을 입력시 {1}을 반환")
        @CsvSource({"1,1", "2,2", "+4,4", "0,0"})
        @DisplayName("사용자의 input을 기반으로 시도 횟수를 get")
        void validTestOfGetTryCount(String userInput, int expectedTryCount) {
            // given
            setSetIn(userInput);
            // when
            int tryCount = inputView.getTryCount();
            // then
            assertThat(tryCount).isEqualTo(expectedTryCount);
        }

        @ParameterizedTest(name = "사용자가 {0}을 입력하면 숫자가 아니기 때문에 예외가 반환된다.")
        @ValueSource(strings = {"r", "가", "."})
        @DisplayName("사용자가 숫자가 아닌 값을 입력하면 예외 반환")
        void invalidTest1(String userInput) {
            // given
            setSetIn(userInput);
            // when then
            assertThatThrownBy(() -> inputView.getTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Errors.INPUT_IS_NOT_INTEGER);
        }

        @ParameterizedTest(name = "사용자가 {0}을 입력하면 음수이기 때문에 예외가 반환된다.")
        @ValueSource(strings = {"-1", "-3"})
        @DisplayName("사용자가 음수를 입력하면 예외 반환")
        void invalidTest2(String userInput) {
            // given
            setSetIn(userInput);
            // when then
            assertThatThrownBy(() -> inputView.getTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Errors.INPUT_IS_NOT_NATURAL_NUMBER_ERROR);
        }

    }
}
