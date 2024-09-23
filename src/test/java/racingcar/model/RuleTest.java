package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RuleTest {
    @Test
    @DisplayName("글자수가 5자 이하일 때 글자수 제한 오류 발생 여부")
    void NonNameLenghtError() {
        //Given
        Rule rule = new Rule();
        String carName = "carA";

        //When & Then
        assertDoesNotThrow(() -> rule.CarNameLengthLimit(carName));
    }

    @Test
    @DisplayName("글자수가 n자 초과일 때 글자수 제한 오류 발생 여부")
    void nameLenghtError() {
        //Given
        Rule rule = new Rule();
        String carName = "carABC";

        //When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rule.CarNameLengthLimit(carName));

        //Then
        assertEquals("자동차 이름은 5자 이하만 가능합니다. 프로그램을 종료합니다.", exception.getMessage());
    }
}
