package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingLapTest {

    @Test
    @DisplayName("시도 횟수가 1 이상이면 정상적으로 생성된다.")
    void createRacingLapSuccess() {
        int validCount = 5;

        RacingLap racingLap = new RacingLap(validCount);

        assertThat(racingLap.getLapCount()).isEqualTo(validCount);
    }

    @Test
    @DisplayName("시도 횟수가 1 미만이면 IllegalArgumentException 예외가 발생한다.")
    void createRacingLapFail() {
        int invalidCount = 0;

        assertThatThrownBy(() -> new RacingLap(invalidCount)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("횟수는 1회 이상으로 입력해주세요.");
    }

    @Test
    @DisplayName("시도 횟수를 정수로 입력하지 않으면 InputMismatchException이 발생한다.")
    void createRaingLapFail() { // todo: 입력이 정수가 아닌경우 테스트
        //given

        //when

        //then
    }
}
