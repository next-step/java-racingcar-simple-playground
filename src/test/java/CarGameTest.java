import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarGameTest {

  @Test
  void 자동차게임에는_여러자동차가_참여할수_있다() {
    final List<Car> cars = List.of(
        new Car("neo"), new Car("brie")
    );
    final CarGame carGame = new CarGame(cars);

    assertThat(carGame.getCars())
        .usingRecursiveFieldByFieldElementComparator()
        .containsExactlyInAnyOrderElementsOf(cars);
  }

  @Test
  void 횟수만큼_전진또는_멈춘다(){
    final List<Car> cars = List.of(
        new Car("neo", new FixedNumberGenerator(4)),
        new Car("brie", new FixedNumberGenerator(0))
    );
    final CarGame carGame = new CarGame(cars);

    carGame.play(2);

    final List<Car> expected = List.of(
        new Car("neo", 2), new Car("brie", 0)
    );
    final List<Car> actual = carGame.getCars();

    assertThat(actual)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("numberGenerator")
        .containsExactlyInAnyOrderElementsOf(expected);
  }
}
