package inputViewTest;

import global.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class InputViewTest {
    @Test
    @DisplayName("자동차 이름이 ,를 기준으로 스플릿 테스트")
    void getCarNamesTest(){
        SystemSetIn.inputStringTestStrat("RRR,CCC,SSS");

        InputView inputView = new InputView();
        String [] testCarNames = inputView.getCarNames();

        assertThat(testCarNames).hasSize(3).as("리스트의 크기는 3이어야 합니다.");
        SystemSetIn.inputTestEnd();
    }

    @Test
    @DisplayName("시도할 회수가 음수일 경우, 에러 테스트")
    void getGameCountTest(){
        SystemSetIn.inputIntTestStrat(-2);

        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.getGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("inputCount can't be less than 1");

        SystemSetIn.inputTestEnd();
    }


}
