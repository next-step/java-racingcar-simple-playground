package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;
import racingcar.controller.InputValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InputValidatorTest {
    @Test
    void 이름은_1자_이상_5자_이하여야_한다() {
        //given
        InputValidator inputValidator = new InputValidator();
        List<String> emptyNameList = List.of("", "name");
        List<String> overlongNameList = List.of("Greedy", "name");
        //when
        IllegalArgumentException e1 = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.validateCarName(emptyNameList)
        );
        IllegalArgumentException e2 = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.validateCarName(overlongNameList)
        );
        //then
        assertAll(
                () -> assertThat(e1.getMessage()).isEqualTo(ErrorMessage.NAME_LENGTH.getMessage()),
                () -> assertThat(e2.getMessage()).isEqualTo(ErrorMessage.NAME_LENGTH.getMessage())
        );
    }

    @Test
    void 중복된_이름이_존재해서는_안된다() {
        //given
        InputValidator inputValidator = new InputValidator();
        List<String> duplicateNameList = List.of("name", "name");
        //when
        IllegalArgumentException e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.validateCarName(duplicateNameList)
        );
        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NAME_DUPLICATE.getMessage());
    }

    @Test
    void 이름은_두_개_이상_입력되어야_한다() {
        //given
        InputValidator inputValidator = new InputValidator();
        List<String> invalidLengthNameList = List.of("name");
        //when
        IllegalArgumentException e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.validateCarName(invalidLengthNameList)
        );
        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.MINIMUM_CAR_COUNT.getMessage());
    }

    @Test
    void 시도횟수는_정수여야_한다() {
        //given
        InputValidator inputValidator = new InputValidator();
        String tryCount = "문자";
        //when
        IllegalArgumentException e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.validatePlayCount(tryCount)
        );
        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    void 시도횟수는_1_이상이어야_한다(String invalidCount) {
        //given
        InputValidator inputValidator = new InputValidator();
        //when
        IllegalArgumentException e = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.validatePlayCount(invalidCount)
        );
        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.MINIMUM_TRY_COUNT.getMessage());
    }
}
