package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingTest {

  @Test
  @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다")
  void throwExceptionWhenAttemptsLessThenOne() {
    assertThatThrownBy(() -> CarRacing.validateAttempts(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("시도 횟수는 1 이상이어야 합니다.");
  }

  @Test
  @DisplayName("우승작 한 명일 경우 우승자 한 명을 반환한다")
  void returnOneWinnerWhenOneWinner() {
    // Given
    List<String> carNames = List.of("벤츠", "아우디", "제네시스");
    CarRacing racing = new CarRacing(carNames, 1, new TestNumberGenerator(new int[]{1, 5, 2}));

    // When
    racing.playRound();

    // Then
    List<String> winners = racing.findWinners();
    assertThat(winners).containsExactly("아우디");
  }

  @Test
  @DisplayName("우승자가 여러 명일 경우 모든 우승자를 반환한다")
  void returnAllWinnersWhenMultipleWinners() {
    // Given
    List<String> carNames = List.of("벤츠", "아우디", "제네시스");
    CarRacing racing = new CarRacing(carNames, 1, new TestNumberGenerator(new int[]{5, 5, 5}));

    // When
    racing.playRound();

    // Then
    List<String> winners = racing.findWinners();
    assertThat(winners).containsExactlyInAnyOrder("벤츠", "아우디", "제네시스");
  }
}
