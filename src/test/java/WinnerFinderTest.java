import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WinnerFinderTest {

  @Test
  @DisplayName("우승작 한 명일 경우 우승자 한 명을 반환한다")
  void returnOneWinnerWhenOneWinner() {
    Cars cars = new Cars(List.of("벤츠", "아우디", "제네시스"));

    cars.getCars().get(0).moveWithSpeed(4);
    cars.getCars().get(1).moveWithSpeed(5);
    cars.getCars().get(2).moveWithSpeed(2);

    List<String> winners = cars.findWinners();
    assertThat(winners).containsExactly("아우디");
  }

  @Test
  @DisplayName("우승자가 여러 명일 겨웅 모든 우승자를 반환한다")
  void returnAllWinnersWhenMultipleWinners() {
    Cars cars = new Cars(List.of("벤츠", "아우디", "제네시스"));

    cars.getCars().get(0).moveWithSpeed(5);
    cars.getCars().get(1).moveWithSpeed(5);
    cars.getCars().get(2).moveWithSpeed(5);

    List<String> winners = cars.findWinners();
    assertThat(winners).containsExactlyInAnyOrder("벤츠", "아우디", "제네시스");
  }
}
