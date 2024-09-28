package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    @DisplayName("차 이름 string이 제대로 저장되었는 지 확인")
    void saveCarStr() {
        // Given: 모의 입력 값을 설정
        String input = "CarA,CarB,CarC";
        Scanner scanner = new Scanner(input);

        // When: askCarNames 메서드를 호출
        InputView inputView = new InputView();
        String carNamesStr = inputView.askCarNames();

        // Then: 입력받은 값이 예상대로 저장되었는지 확인
        assertEquals("CarA,CarB,CarC", carNamesStr);
    }
}
