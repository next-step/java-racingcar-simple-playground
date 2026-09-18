import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class InputViewTest {
    @Test
    void 자동차이름을_입력받으면_쉼표를_기준으로_분리하고_공백을_제거한다() {
        // given
        InputView inputView = new InputView(new Scanner(" car1, car2, car3 "));

        // when
        String[] result = inputView.readCarNames();

        // then
        assertThat(result).containsExactly("car1", "car2", "car3");
    }

    @Test
    void 경주횟수를_입력받아_숫자로_변환한다() {
        // given
        InputView inputView = new InputView(new Scanner(" 5 "));

        // when
        int count = inputView.readRaceCount();

        // then
        assertThat(count).isEqualTo(5);
    }
}
