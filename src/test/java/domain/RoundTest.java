package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @Nested
    @DisplayName("정상 입력 테스트")
    class SuccessCases {

        @Test
        @DisplayName("1 이상의 정수로 Round를 생성할 수 있다")
        void createRoundWithValidValue() {
            Round round = new Round(3);

            assertThat(round.getValue()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("예외 입력 테스트")
    class FailureCases {

        @Test
        @DisplayName("0 이하 값으로 Round 생성 시 예외 발생")
        void throwIfRoundLessThanOne() {
            assertThatThrownBy(() -> new Round(0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 라운드는 1 이상의 숫자여야 합니다.");

            assertThatThrownBy(() -> new Round(-2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 라운드는 1 이상의 숫자여야 합니다.");
        }
    }
}
