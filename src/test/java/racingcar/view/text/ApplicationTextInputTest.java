package racingcar.view.text;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;


@SuppressWarnings("NonAsciiCharacters")
public class ApplicationTextInputTest {


    @Test
    void 입력을_파싱할_수_있다() {
        PromptHandler prompt = new Prompts("a,b ,c", "5");
        ApplicationTextInputHandler inputHandler = new ApplicationTextInputHandler(prompt);
        ApplicationTextInput input = inputHandler.promptInput();
        assertThat(input.carNames())
                .map(Car.Name::value)
                .isEqualTo(List.of("a", "b", "c"));

        assertThat(input.gameCount())
                .isEqualTo(5);
    }

    @Test
    void 자동차_이름의_길이가_너무_길면_예외를_발생시킨다() {
        PromptHandler prompt = new Prompts("aefewfwefge,wefwergerge");
        ApplicationTextInputHandler inputHandler = new ApplicationTextInputHandler(prompt);
        assertThatThrownBy(inputHandler::promptCarNames)
                .isInstanceOf(ApplicationTextInputHandler.ParseException.class)
                .hasMessageContaining("자동차 이름");
    }

    @Test
    void 게임_횟수가_숫자가_아니면_예외를_발생시킨다() {
        PromptHandler prompt = new Prompts("notNumber");
        ApplicationTextInputHandler inputHandler = new ApplicationTextInputHandler(prompt);
        assertThatThrownBy(inputHandler::promptGameCount)
                .isInstanceOf(ApplicationTextInputHandler.ParseException.class)
                .hasMessageContaining("게임 횟수");
    }


    static class Prompts implements PromptHandler {

        private final Iterator<String> lines;

        public Prompts(String... lines) {
            this.lines = Arrays.asList(lines).iterator();
        }

        @Override
        public String prompt(String message) {
            return lines.next();
        }

    }

}
