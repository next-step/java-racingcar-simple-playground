package view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputValidatorTest {

    @Test
    void 자동차의_이름이_구분자가_쉼표가_아니면_예외가_발생한다() {
        String inputString = "현대자동차.기아자동차,쌍용자동차";
        assertThatThrownBy(() -> InputValidator.validateCarNames(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 알파벳, 혹은 한글로 이루어지고 쉼표(,)를 기준으로 구분합니다!");
    }

    @Test
    void 자동차의_이름에_특수문자가_포함되면_예외가_발생한다() {
        String inputString = "현대@자동차,기아자동차,쌍용자동차";
        assertThatThrownBy(() -> InputValidator.validateCarNames(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 알파벳, 혹은 한글로 이루어지고 쉼표(,)를 기준으로 구분합니다!");
    }

    @Test
    void 자동차의_이름에_숫자가_포함되면_예외가_발생한다() {
        String inputString = "현대자동차,기아자동차,쌍용자동차2";
        assertThatThrownBy(() -> InputValidator.validateCarNames(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 알파벳, 혹은 한글로 이루어지고 쉼표(,)를 기준으로 구분합니다!");
    }

    @Test
    void 자동차의_이름이_6자_이상이면_예외가_발생한다() {
        List<String> carNames = List.of("한대자동차", "기아자동차", "현대기아자동차");
        assertThatThrownBy(() -> InputValidator.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하입니다!");
    }

    @Test
    void 시도_횟수가_0이하이면_예외가_발생한다() {
        int tryCount = 0;
        assertThatThrownBy(() -> InputValidator.validateTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1이상의 양수입니다!");
    }
}
