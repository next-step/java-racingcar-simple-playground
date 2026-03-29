package view;

import exception.InvalidNumberInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

class VehicleRaceNumberInputTest {

    @DisplayName("숫자가 아닌 시도 횟수가 입력되면 InvalidNumberInputException 예외를 던진다.")
    @ParameterizedTest
    @MethodSource("stringNumberInputMethodSource")
    void getNumberWrongInputTest(String userInput) {
        Scanner sc = new Scanner(userInput);
        Assertions.assertThatThrownBy(() -> VehicleRaceNumberInput.getNumber(sc))
                .isInstanceOf(InvalidNumberInputException.class).hasMessage("Not a Number");
    }

    static Stream<Arguments> stringNumberInputMethodSource() {
        return Stream.of(
                Arguments.arguments("s"),
                Arguments.arguments(";"),
                Arguments.arguments(".")
        );
    }
}
