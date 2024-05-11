package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Input 테스트")
class InputTest {

    @Test
    @DisplayName("모든 이름은 5글자 이하여야 합니다.")
    void 자동차_이름의_길이가_5보다_크면_생성에_실패한다() {

        final String[] carName = {"aaaaaa", "aa", "aaa"};
        boolean isTrue = Input.nameIsGood(carName);
        assertNotEquals(true, isTrue, "오류 발생시 nameIsGood 함수는 6글자 이상 허용을 뜻함");
    }

    @Test
    @DisplayName("모든 이름은 공백이 없어야 합니다.")
    void 자동차_이름에_공백이_있으면_생성에_실패한다() {
        final String[] carName = {" ", "aa", "aaaa"};
        boolean isTrue = Input.nameIsGood(carName);
        assertNotEquals(true, isTrue, "오류 발생시 nameIsGood 함수는 공백 허용을 뜻함");
    }

}