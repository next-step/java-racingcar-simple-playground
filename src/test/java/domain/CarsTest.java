package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  @Test
  @DisplayName("자동차 대수가 2 이하면 예외가 발생한다")
  void throwExceptionWhenCarCountOneOrLess() {
    assertThatThrownBy(() -> Cars.validateCarCount(1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("경주에는 최소 2대의 자동차가 필요합니다.");
  }
}
