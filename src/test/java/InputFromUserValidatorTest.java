import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.InputFromUserValidator;

import java.util.ArrayList;
import java.util.List;

public class InputFromUserValidatorTest {

    @Test
    @DisplayName("이름의 길이가 5가 넘어가는 자동차가 있을 경우 예외를 발생시킨다.")
    public void checkCarNameLengthOver5() {
        //given
        List<String> carNames = new ArrayList<String>(List.of("aaaaa", "bbb", "cccc", "dddddd"));

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputFromUserValidator.checkCarNames(carNames);
        });
    }

    @Test
    @DisplayName("이름이 없는 경우 예외를 발생시킨다.")
    public void checkCarNameIsEmpty() {
        //given
        List<String> carNames = new ArrayList<String>(List.of("", "bbb", "cccc"));

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputFromUserValidator.checkCarNames(carNames);
        });
    }

    @Test
    @DisplayName("실행 횟수가 숫자가 아닌 경우 예외를 발생시킨다.")
    public void checkExecutionCountIsNumber() {
        //given
        String executionCount = "notNumber";

        //when, then
        Assertions.assertThrows(NumberFormatException.class, () -> {
            InputFromUserValidator.checkExecutionsCount(executionCount);
        });
    }
}
