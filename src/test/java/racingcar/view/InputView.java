package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputView {
    @Test
    void 차_이름_string이_제대로_저장되었는_지_확인() {
        // Given
        String input = "CarA,CarB,CarC";
        //Scanner scanner= new Scanner;

        // When: askCarNames 메서드를 호출
        InputView inputView = new InputView();
       // String carNamesStr = inputView.askCarNames();

        // Then: 입력받은 값이 예상대로 저장되었는지 확인
        //assertEquals("CarA,CarB,CarC", carNamesStr);
    }
}
//커밋은 로컬인가? 깃 레지스터 인가?
