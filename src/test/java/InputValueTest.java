import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import controller.RacingGameController;
import exception.ErrorMessage;
import util.NameParser;
import util.TimesValidator;

public class InputValueTest {

    @ParameterizedTest
    @MethodSource("provideEmptyCarNames")
    public void 이름이_비어있는_경우_예외를_발생한다(List<String> names) {
        RacingGameController racingGameController = new RacingGameController();

        assertThatThrownBy(() -> racingGameController.joinCars(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.EMPTY_CAR_NAME);
    }

    @ParameterizedTest
    @MethodSource("provideOverLengthCarNames")
    public void 이름이_5자를_초과한_경우_예외를_발생한다(List<String> names) {
        RacingGameController racingGameController = new RacingGameController();

        assertThatThrownBy(() -> racingGameController.joinCars(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateCarName")
    public void 이름이_중복되는_경우_예외를_발생한다(List<String> names) {
        RacingGameController racingGameController = new RacingGameController();

        assertThatThrownBy(() -> racingGameController.joinCars(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.DUPLICATE_CAR_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "asdasd",
        "2147483648",
        "9999999999"
    })
    public void 횟수에_문자_또는_범위를_벗어나는_값을_입력받은_경우_예외를_발생한다(String timesStr) {
        assertThatThrownBy(() -> TimesValidator.validateAndGetTimes(timesStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.INVALID_TIMES_INPUT);
    }

    @Test
    public void 횟수에_음수를_입력받은_경우_예외를_발생한다() {
        String timesStr = "-1";

        assertThatThrownBy(() -> TimesValidator.validateAndGetTimes(timesStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.NEGATIVE_ATTEMPT_COUNT);
    }

    static Stream<List<String>> provideEmptyCarNames() {
        return Stream.of(
                NameParser.parse("neo,"),
                NameParser.parse(" "),
                NameParser.parse("  ")
        );
    }

    static Stream<List<String>> provideOverLengthCarNames() {
        return Stream.of(
                NameParser.parse("asd,qweqwe"),
                NameParser.parse("qwerty,ads")
        );
    }

    static Stream<List<String>> provideDuplicateCarName() {
        return Stream.of(
            NameParser.parse("asd,asd"),
            NameParser.parse("qwe,qwe")
        );
    }
}
