package view;

import constants.ErrorMessage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class InputViewTest {
    InputView inputView;

    @ParameterizedTest
    @ValueSource(strings = {"alice, bo! b", "ha|he", "alice bob"})
    @DisplayName("이름 입력은 쉼표(,) 로 구분된다.")
    protected void testParseIntoNamesWithWrongDelimiter(String testInput) {
        Scanner scanner = new Scanner(
            new ByteArrayInputStream(testInput.getBytes())
        );

        this.inputView = new InputView(scanner);

        Exception expectedException = Assertions.assertThrows(IllegalArgumentException.class,
                ()-> inputView.getNamesFromUser());

        Assertions.assertEquals(ErrorMessage.CAR_NAME_INPUT_NOT_CORRECT_FORMAT, expectedException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"anna, bob", "hello"})
    @DisplayName("올바른 이름 입력")
    protected void testParseIntoNamesGoodInput(String testInput) {
        Scanner scanner = new Scanner(
            new ByteArrayInputStream(testInput.getBytes())
        );
        this.inputView = new InputView(scanner);

        Assertions.assertDoesNotThrow(() -> inputView.getNamesFromUser());
    }

    @Test
    @DisplayName("올바른 실행 횟수 입력")
    protected void testGetRoundNumber() {
        Scanner scanner = new Scanner(
            new ByteArrayInputStream("100".getBytes())
        );
        this.inputView = new InputView(scanner);

        Assertions.assertDoesNotThrow(() -> inputView.getRoundNumber());
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 실행 횟수 입력")
    @ValueSource(strings = {"asdf", "12A123", "1.0", "1 1"})
    protected void testGetRoundNumberWithWrongInput(String userInput) {
        Scanner scanner = new Scanner(
            new ByteArrayInputStream(userInput.getBytes())
        );
        this.inputView = new InputView(scanner);
        Exception exceptedException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputView.getRoundNumber());

        Assertions.assertEquals(ErrorMessage.INPUT_IS_NOT_INTEGER, exceptedException.getMessage());
    }
}