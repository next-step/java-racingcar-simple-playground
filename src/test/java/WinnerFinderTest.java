import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WinnerFinderTest {

  @Test
  void 우승자가_한_명일_경우_우승자_한명을_반환한다() {
    Car car1 = new Car("벤츠");
    Car car2 = new Car("아우디");
    Car car3 = new Car("제네시스");

    car1.moveWithSpeed(4);
    car2.moveWithSpeed(5);
    car3.moveWithSpeed(2);

    List<String> winners = WinnerFinder.findWinners(List.of(car1, car2, car3));
    assertThat(winners).containsExactly("아우디");
  }

  @Test
  void 우승자가_여러_명일_경우_모든_우승자를_반환한다() {
    Car car1 = new Car("벤츠");
    Car car2 = new Car("아우디");
    Car car3 = new Car("제네시스");

    car1.moveWithSpeed(5);
    car2.moveWithSpeed(5);
    car3.moveWithSpeed(5);

    List<String> winners = WinnerFinder.findWinners(List.of(car1, car2, car3));
    assertThat(winners).containsExactlyInAnyOrder("벤츠", "아우디", "제네시스");
  }
}
