package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingLapTest {

    @Test
    @DisplayName("시도 횟수가 1 이상이면 정상적으로 생성된다.")
    void createRacingLapSuccess() {
        // given
        int validCount = 5;

        // when
        RacingLap racingLap = new RacingLap(validCount);

        // then
        assertThat(racingLap.getLapCount()).isEqualTo(validCount);
    }

    @Test
    @DisplayName("시도 횟수가 1 미만이면 IllegalArgumentException 예외가 발생한다.")
    void createRacingLapFail() {
        // given
        int invalidCount = 0;

        // when, then
        assertThatThrownBy(() -> new RacingLap(invalidCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("횟수는 1회 이상으로 입력해주세요.");
    }

    @Test
    @DisplayName("시도 횟수를 정수로 입력하지 않으면 InputMismatchException이 발생한다.")
    void createRaingLapFail() { //정수입력 안하는것을 테스트 어떻게할 것인가... & main 실행했을때도 해당 오류가 안터지는데 어떻게 수정할것인가
        //given

        //when

        //then
    }
}
